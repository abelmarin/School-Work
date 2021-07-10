#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <string.h>

#define LINE_SIZE 256

int usage( char * name ){
	printf( "Usage: %s <file to write>\n", name );
	return 1;
}

int main( int argc, char * argv[] ){
	if ( argc != 2 )
		return usage( argv[0] );

	// open the file for writing, provide no permissions
	int file= creat( argv[1], 0 );
	if ( file == -1 ){
		perror( argv[1] );
		return 1;
	}

	fchmod( file, S_IRUSR | S_IWUSR ); // give user read and write permissions
	
	char line[LINE_SIZE];
	int length;
	while( fgets( line, LINE_SIZE, stdin ) ){
		length= strlen( line ); // length of string entered
		write( file, line, length );
	}
	// close the file
	close( file );	
}
