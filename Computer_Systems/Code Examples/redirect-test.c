/*/
redirect-test.c

Use dup2 to redirect stdout to a file
//*/

#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>

#define LINE_SIZE 256

void usage( char prog[] ){
	printf( "Usage:\n   %s <file to write>\n", prog );
}

int main( int argc, char * argv[] ){
	char line[LINE_SIZE];
	int length;
	
	if ( argc != 2 ){
		usage( argv[0] );
		return 1;
	}
	int file= creat( argv[1], S_IRUSR | S_IWUSR );
	dup2( file, STDOUT_FILENO ); // STDOUT_FILENO = 1 
	while( fgets( line, LINE_SIZE, stdin ) ){
		printf( "%s", line ); // output the line
	}
}
