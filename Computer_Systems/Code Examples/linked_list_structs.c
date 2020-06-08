/* Karen Heart
 * Linked list example
 */
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node{
	char * token;
	struct node * next_node;
};

typedef struct node * NODE;

void printList( NODE head ) {
	NODE cur_node= head;
	while( cur_node ) {
		printf( "%s\n", cur_node->token );
		cur_node= cur_node->next_node;
	}
}

void releaseList( NODE head ) {
	NODE cur_node= head;
	NODE free_node;
	while( cur_node ) {
		free( cur_node->token );
		free_node= cur_node;
		cur_node= cur_node->next_node;
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
	NODE list_head= NULL;
	NODE cur_node;
	while( line[i] != '\0' ){
		// find the next token
		switch( line[i] ){
			case ' ':
			case '\t':
			case '\n':
				// token ended, create a node
				cur_node= (NODE)malloc( sizeof(struct node) );
				token_size= i - start_index;
				cur_node->token= (char*)malloc( token_size + 1); // add 1 for null terminator
				memcpy( cur_node->token, line + start_index, token_size ); // copy token to node
				*(cur_node->token + token_size)= '\0'; // terminate the token
				cur_node->next_node= list_head;
				list_head= cur_node;
				// reset start of token
				start_index= i + 1;
				// fall through
			default: // all other values
				i++;
		}
	}

	printList( list_head );	
	releaseList( list_head );	
}
