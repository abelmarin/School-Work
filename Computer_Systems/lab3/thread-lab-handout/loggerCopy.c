#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <stdlib.h>
#include <pthread.h>
#include "message-lib.h"
#include "message-lib.c"
#include <semaphore.h>

// forward declarations
int error_msg( char * msg );
int usage( char name[] );

// a function to be executed by each thread
void recv_log_msgs( void * arg );

// globals
int log_fd; // opened by main() but accessible by each thread

// file descriptor for the client connection
int clientfd;

// variable for the size of the message received from the client
int read_size;

// char buffer for message from the client
char client_message[4000];

// Error logging helper function
int error_msg( char * msg ) {
    printf( "%s\n", msg );
    return -1;
}

// Helper function that accepts a client connection as an argument
void recv_log_msgs( void * arg ) {

    // loops to receive messages from a client;
    // when the connection is closed by the client,
    // close the socket
    // get the client file descriptor from arguments
    int clientfd= ((int *) arg);

    // While there are still bytes to be read from the client, write the client message to the log
    while( (read_size = recv(clientfd , client_message , 4000 , 0)) > 0 ) {
        write(log_fd , client_message , strlen(client_message));
    }

    // print out message when client connection is closed
    if(read_size == 0) 
        puts("Connection Terminated");

    // if there is a problem with the connection, call the error message helper function
    else if(read_size == -1) 
        return error_msg("Connection Failed");

    // close client connection file description
    close( clientfd );
    return NULL;
}

// helper function for printing the usage information

int usage( char name[] ) {
    printf( "Usage:\n" );
    printf( "\t%s \n", name );
    return 1;
}

int main(int argc, char **argv) {

    // return usage if arguments aren't satisfactory
    if ( argc != 3 ) 
        return usage( argv[0] );

    // open the log file for appending
    log_fd = open(argv[1], O_RDWR | O_APPEND | O_CREAT, 0666);

    // If there is a problem opening the file, call the error handling function
    if ( log_fd == -1 ) {
        error_msg("No such file");
        return error_msg(argv[1]);
    }

    // loop to wait for connections;
    // as each connection is accepted,
    // launch a new thread that calls
    // recv_log_msgs(), which receives
    // messages and writes them to the log file
    // forward declare the thread for the client connection

    pthread_t client_thread;

    // loop and wait for connections
    while(1){
        printf( "Waiting for a connection on UDS path %s...\n", argv[2] );
        // accept connections from the client

        // create a new thread for each connection that comes in and call the helper function
        pthread_create( &client_thread, NULL, recv_log_msgs, &clientfd );
    }

    // close the log file
    close(log_fd);

    return 0;
}