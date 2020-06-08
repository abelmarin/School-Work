#include <stdio.h>

void test1( char * address, void * data ){
	fprintf( stderr, "Test1:\n" );
	fprintf( stderr, "   address: %p\n", address );
	fprintf( stderr, "     value: %ld\n", (long)data );
	fprintf( stderr, "   value at address: %ld\n",	 *((long*)address) );
}

void test2( char * address, void * data ){
	fprintf( stderr, "Test2:\n" );
	fprintf( stderr, "   address: %p\n", address );
	fprintf( stderr, "     value: %ld\n", (long)data );
	fprintf( stderr, "   value at address: %ld\n",	 *((long*)address) );
}

void test3( char * address, void * data ){
	fprintf( stderr, "Test3:\n" );
	fprintf( stderr, "   address: %p\n", address );
	fprintf( stderr, "     value: %ld\n", (long)data );
	fprintf( stderr, "   value at address: %ld\n",	 *((long*)address) );
}

int main(){
	long x= 1035; // an arbitrary, numeric value
	test1( (char *)(&x), (void *)x );
	x= 3211; // another arbitrary value
	test2( (char *)(&x), (void *)x );
	x= 6201; // guess...
	test3( (char *)(&x), (void *)x );
}
