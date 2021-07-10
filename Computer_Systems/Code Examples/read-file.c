#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>

int usage( char * name ){
	printf( "Usage: %s <file to read>\n", name );
	return 1;
}

int main( int argc, char * argv[] ){
	if ( argc != 2 )
		return usage( argv[0] );

	// open the file to copy
	int file= open( argv[1], O_RDONLY, 0 );
	if ( file == -1 ){
		perror( argv[1] );
		return 1;
	}
	char buffer[256];
	int bytes_read;
	do{
		// read one byte
		bytes_read= read( file, buffer, 256 );
		if ( bytes_read > 0 ){
			int i;
			for( i= 0; i < bytes_read; i++ )
				printf( "%c", buffer[i] );
		}
	} while ( bytes_read > 0 ); // zero bytes == EOF

	if ( bytes_read == -1 )
		perror( "file read" );
			
	// close the file
	close( file );	
}
