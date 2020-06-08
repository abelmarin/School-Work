#include <stdio.h>
#include <stdlib.h>

struct node{
	int n;
};

void print_nodes( struct node ** nodes ){
	int i,j;
	for( i= 0; i<2; i++ )
		for( j= 0; j<3; j++)
			printf( "nodes[%d][%d].n: %d\n", i,j,nodes[i][j].n);
}

int main(){
	struct node ** nodes= malloc( 2*sizeof(struct node*));
	int i,j;
	for( i= 0; i<2; i++ )
		nodes[i]= calloc( 3,sizeof(struct node));
	print_nodes( nodes );
	for( i= 0; i<2; i++ )
		for( j= 0; j<3; j++){
			nodes[i][j].n= (i*10)+j;
			//printf( "nodes[%d][%d].n: %d\n", i,j,nodes[i][j].n);
		}
	print_nodes( nodes );
}

