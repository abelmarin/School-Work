#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>

int usage( char * name ){
	printf( "Usage: %s <file to write>\n", name );
	return 1;
}

int main( int argc, char * argv[] ){
	if ( argc != 2 )
		return usage( argv[0] );

	// open the file for writing
	int file= creat( argv[1], S_IRUSR | S_IWUSR );
	if ( file == -1 ){
		perror( argv[1] );
		return 1;
	}
	char cur_char;
	int bytes_read;
	do{
		// read one byte
		bytes_read= read( STDIN_FILENO, &cur_char, 1 );
		if ( bytes_read > 0 )
			write( file, &cur_char, 1 );
	} while ( bytes_read > 0 ); // zero bytes == EOF

	// close the file
	close( file );	
}
