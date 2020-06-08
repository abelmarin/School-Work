/*This example taken from Bryant & O'Hallaron, 2nd Ed., p. 958;
 * for a more recent, similar example, see 3rd Ed., p. 996. 
 */
 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

// global variable
volatile int count= 0; // make it volatile to prevent optimizations

void * thread_fun( void * arg ){
	int i, task_count= *( (int *) arg );
	for( i= 0; i < task_count; i++ )
		count++;
	return NULL;
}

int usage(){
	printf( "Usage: bad-thread <task count>\n" );
	return -1;
}
int main( int argc, char * argv[] ){
	// get the task count
	if ( argc != 2 )
		return usage();
		
	int task_count= atoi( argv[1] );
	pthread_t tid1, tid2;
	pthread_create( &tid1, NULL, thread_fun, &task_count );
	pthread_create( &tid2, NULL, thread_fun, &task_count );
	pthread_join( tid1, NULL );
	pthread_join( tid2, NULL );
	
	printf( "count is now %d\n", count );
	return 0;
}
