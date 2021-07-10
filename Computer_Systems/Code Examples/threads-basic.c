#include <stdio.h>
#include <pthread.h>

void * func1(void * vargp){
	printf( "Hello from func1!\n" );
	return NULL;
}

void * func2(void * vargp){
	printf( "Hello from func2!\n" );
	return NULL;
}

void * func3(void * vargp){
	printf( "Hello from func3!\n" );
	return NULL;
}

int main(){
	pthread_t tid1, tid2, tid3;
	pthread_create(&tid1, NULL, func1, NULL);
	pthread_create(&tid2, NULL, func2, NULL);
	pthread_create(&tid3, NULL, func3, NULL);
	pthread_exit( NULL ); // prevent main from exiting the program
}
