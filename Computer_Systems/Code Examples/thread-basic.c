#include <stdio.h>
#include <pthread.h>

void * thread_func(void * vargp);

int main(){
	pthread_t tid;
	void * thread_return;
	pthread_create(&tid, NULL,
	 thread_func, NULL);
	printf( "Child Thread ID: %lu\n", tid );
	pthread_exit( NULL ); // needs this call or pthread_join to
						  // prevent main from exiting the program
	//pthread_join( tid, &thread_return );  
}

/* Thread routine */
void * thread_func(void * vargp){
	printf( "Hello from thread_func!\n" );
	return NULL;
}
