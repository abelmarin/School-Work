#include <stdio.h>

int main( int argc, char * argv[] )
{
	printf( "Enter a calculation:\n" );

	int operand1, operand2;
	char operator;
	printf( "Enter a simple calculation, i.e., operand1 operator operand2\n" );
	scanf( "%d %c %d", &operand1, &operator, &operand2 );
	printf( "%d %c %d = ", operand1, operator, operand2 );
	printf( "\n" );
	return 0; // optional
}
