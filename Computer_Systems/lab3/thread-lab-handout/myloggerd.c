/* myloggerd.c
 * Source file for thread-lab
 * Creates a server to log messages sent from various connections
 * in real time.
 *
 * Student: Abel Marin
 */
 
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
int usage( char name[] );
// a function to be executed by each thread
void * recv_log_msgs( void * arg );

// globals
int log_fd; // opened by main() but accessible by each thread
sem_t mutex; // global mutex
int read_size; // size of messege received 

void * recv_log_msgs( void * arg ){
	
	// loops to receive messages from a connection;
	// when read_msg returns zero, terminate the loop
	// and close the connection
	char buffer[256];
	int connection = (int*) arg;
	int msg = read_msg(connection, buffer, 256);
	while (msg > 0) {
		write(log_fd, buffer, msg);
		
	}
	close_connection(connection);

	return NULL;
}

int usage( char name[] ){
	printf( "Usage:\n" );
	printf( "\t%s <log-file-name> <UDS path>\n", name );
	return 1;
}

int main( int argc, char * argv[] ) {
	if (argc != 3)
		return usage( argv[0] );
		
	// open the log file for appending
	log_fd = open(argv[1], O_RDWR | O_APPEND | O_CREAT);
	
	// permit message connections
	int listener = permit_connections(argv[1]);
	if (listener == -1)
		return -1;
			
	// loop to accept message connections;
	// as each connection is accepted,
	// launch a new thread that calls
	// recv_log_msgs(), which receives
	// messages and writes them to the log file			
	// when accept_next_connection returns -1, terminate the loop
	pthread_t connectThread[10];
	int countConnections = 0;

	while(1) {
		int connection = accept_next_connection(listener);
		if (connection == -1)
			// break;

		countConnections++;
		
		pthread_t tid;
		
		pthread_create(&tid, NULL, recv_log_msgs,connection);

		
		connectThread[countConnections] = tid;


	}

	int i;
	for (i = 0; i<countConnections; i++) {
		pthread_join(connectThread[i], NULL);
		
	}
	
	// close the listener
	close_listener(listener);
	
	// close the log file
	close(log_fd);

	return 0;
}
