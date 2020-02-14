#include <stdio.h>

/*
CSC 373 Winter 2020 Prof. Lytinen
Homework assignment 3
Due:  Date and time as specified on D2L

In this assignment, you must complete
the 5 functions below.  Each function's body
should consist of a single C statement.  Furthermore,
you may not use control statements, such as if, switch, 
or any kind of loop.  For each problem, you are also 
restricted to the operators and constants as specified.

In the descriptions of these functions, I am assuming 
that the variable "xptr" points to a variable "x" of 
the right type. 
*/

/* 1.  Write a function zero, which sets a variable x to zero.  
       A pointer to x is passed as a parameter.  YOU MAY
       USE NO CONSTANTS in this function, and must
       restrict yourself to using the assignment operator,
       the dereferencing operator, and one or more of 
       the bitwise operators.
*/

void zero(int *xptr) {
    *xptr = *xptr ^ *xptr;
}

/* 2.  Write a function to set x to be the maximum unsigned long
       integer.  The parameter passed to the function is a 
       pointer to x.  You may only use the constant 0 in 
       this function, and must restrict yourself to using
       the assignment operator, the dereferencing operator,
       and the bitwise operators.
*/

void maximum(unsigned long *xptr) {
    *xptr = ~0;
}

/* 3.  Write a function to set x to be the minimum long
       integer.  The parameter passed to the function is a 
       pointer to x.  You may only use the constants 0-63 in 
       this function, and must restrict yourself to using
       the assignment operator, the dereferencing operator,
       the bitwise operators, and the shift operators.   You
       may need to use the casting operator as well (  ).
*/


void minimum(long *xptr) {
    *xptr = ~(long) 0 << 63;
}

/* 4.  Write a function which sets the integer x to negative x.
       The parameter passed to the function is a pointer to x.
       You may only use the constant 1 in this function,
       and must restrict yourself to the assignment operator, 
       the dereferencing operator, the bitwise operators, and 
       the + operator.
*/

void negative(int *xptr) {
    *xptr = ~*xptr + 1;
}

/* 5.  Write a function called set_byte.  It is passed 3
       parameters:  a pointer to an unsigned long x, an
       index i, and a new value v for the byte.
       The function should change the ith byte of x to
       v.  Byte 0 is x's least significant byte; byte 1
       is the next least significant byte, etc.; byte 7
       is x's most significant byte.  You may only use the
       constants 0-255 in this function, and must restrict
       yourself to the the assignment operator, the
       dereferencing operator, multiplication, bitwise 
       operators and shift operators.
*/

void set_byte(unsigned long *xptr, int i, char v) {
    int shift = 8*i;
    long v_new = v << (shift);
    long empty_bits = ~(255 << (shift));
    *xptr = (empty_bits & *xptr) | v_new;
}

