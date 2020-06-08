#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>

int usage( char * name ){
	printf( "Usage: %s <file to check>\n", name );
	return 1;
}

int main( int argc, char * argv[] ){
	if ( argc != 2 )
		return usage( argv[0] );
		
	struct stat stat_struct;
	if ( stat( argv[1], &stat_struct ) == -1 ){
		perror( "fstat file" );
		return 1;
	}
	printf( "User permissions:\n" );
	if ( stat_struct.st_mode & S_IRUSR )
		printf( "  read\n" );
	if ( stat_struct.st_mode & S_IWUSR )
		printf( "  write\n" );
	if ( stat_struct.st_mode & S_IXUSR )
		printf( "  execute\n" );		
}
