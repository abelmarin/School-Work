/* Karen Heart
 * Linked list example
 */
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printList( char ** head ) {
	char ** node= head;
	while( node ) {
		//printf( "node: %p\n", node );
		printf( "%s\n", (char *)(*node) );
		node= (char **)(*(node + 1));
	}
}

void releaseList( char ** head ) {
	char ** node= head;
	char ** free_node;
	while( node ) {
		//printf( "node: %p\n", node );
		free( (char *)(*node) );
		free_node= node;
		node= (char **)(*(node + 1));
		free( free_node );
	}
}

#define LINE_SIZE 80

int main() {	
	// read a line of input from stdin
	// parse the line into string tokens
	// create a node for each token
	// link the nodes together
	char line[LINE_SIZE];
	fgets( line, LINE_SIZE, stdin );
	int i= 0;
	int start_index= 0;
	int token_size;
	char ** list_head= NULL;
	char ** node;
	while( line[i] != '\0' ){
		// find the next token
		switch( line[i] ){
			case ' ':
			case '\t':
			case '\n':
				// token ended, create a node
				node= (char**)malloc( sizeof(char*) * 2 ); // ptr to token + address of next node
				//printf( "node address: %p\n", node );
				token_size= i - start_index;
				*node= (char*)malloc( token_size + 1); // add 1 for null terminator
				memcpy( *node, line + start_index, token_size ); // copy token to node
				*(*node + token_size)= '\0'; // terminate the token
				//printf( "\ttoken: %s\n", *node );
				//printf( "\tnext node: %p\n", *(node + sizeof(char*)) );
				*(node + 1)= (char*)list_head;
				//printf( "\tnext node: %p\n", *(node + 1) );
				list_head= node;
				// reset start of token
				start_index= i + 1;
				// fall through
			default: // all other values
				i++;
		}
	}

	//printf( "list head: %p\n", list_head );
	printList( list_head );	
	releaseList( list_head );	
}
