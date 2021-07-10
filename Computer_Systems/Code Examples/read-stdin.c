#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>

int main( int argc, char * argv[] ){
	char cur_char;
	int bytes_read;
	do{
		// read one byte
		bytes_read= read( STDIN_FILENO, &cur_char, 1 );
		if ( bytes_read > 0 )
			printf( "%c", cur_char );
	} while ( bytes_read > 0 ); // zero bytes == EOF
	if ( bytes_read == -1 )
		perror( "stdin read" );			
	// no need to close stdin
}
