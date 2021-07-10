#include <stdio.h>

// Abel Marin

/* CSC 373 Spring 2019 -- Lytinen
   Homework 4:  Restricted C 

   This is a (hopefully) short programming assignment,
   intended to get you used to aspects of the programming style
   of assembly language.  It will be graded on a scale 
   of 0-10.  There are 5 problems, worth 2 points each.
   
   In this homework, your job is to rewrite each of the 5
   functions below, but only using a limited form of C.
   The limitations are:

   1.  Array syntax [ ] is not allowed   
   2.  You may not use the keywords "for", "while", or "do".
       Instead, you will use "goto" (see below)
   3.  The body of an "if" statement must consist of only a 
       single "goto" statement
   4.  No "else" statements are allowed
   5.  You may not use the modulus operator %.  All other arithmetic
       operators are allowed.
 
   Use of the assignment operator is permitted.
   Use of bitwise and shift operators is encouraged.
   
   ----------------
   
   goto statements
   
   Many of you have probably never used a goto statement,
   although it is part of the C language.  The syntax is:
   
   goto <label>;
   
   Statements in C may be labeled.  The label is an identifier
   followed by a ":", preceding the statememnt. 
   For example:
   
   L1:  x = 0;
   
   Below is an example of a function which is written to conform
   to these specifications.
   
int factorial(int x) {
  int answer = 1;
  int i = 2;
 L1: if (i > x) goto L2;
  answer *= i;
  i += 1;
  goto L1;
 L2:  return answer;

---------------------

*/
// Problem 1.
// reverse the order of the integers in x
// void reverse(int x[], int len) { // array syntax not allowed
// 	int i=0, j=len-1;
// 	while (i<j) {           // while not allowed
// 		int temp = x[i];    // array syntax not allowed
// 		x[i++] = x[j];      // array syntax, ++ not allowed
// 		x[j--] = temp;      // array syntax, -- not allowed
// 	}
// }

void reverse(int *x, int len) {
  int *first = x;
  int *last = x + len-1;
  L1: if (first>=last) goto L2;
    int temp = *first;
    *first = *last;
    *last = temp;
    first = first + 1;
    last = last - 1;
    goto L1;
  L2: return;
}

// Problem 2.
// return the maximum integer in x
// int max(int x[], int len) { // array syntax not allowed
//   int answer = x[0];        // array syntax not allowed
//   int i;
//   for (i=1; i<len; i++)     // for loops not allowed
//     if (x[i] > answer)      // array syntax not allowed
//       answer = x[i];        // if must be followed by goto
//                             // array syntax not allowed
//   return answer;
// }

int max(int *x, int len) {
  int answer = 0;
  if (len <= 0) goto end;
  answer = *x;
  int i = 0;
  start: if(i >= len) goto end;
    if (*x > answer) goto greater;
    i = i + 1;
    x = x + 1;
    goto start;
  greater: answer = *x;
    goto start;
  end: return answer;
}

// Problem 3.
// emulate string library's strcpy function
// void strcpy373(char dest[], char src[]) {  // array syntax not allowed
//   int i;
//   for (i=0 ; src[i] != '\0'; i++) // for loops not allowed
//                                   // array syntax not allowed
//     dest[i] = src[i];             // array syntax not allowed
//   dest[i] = '\0';                 // array syntax not allowed
// }

void strcpy373(char *dest, char *src) {
  start: if(*src == '\0') goto end;
    *dest = *src;
    dest = dest + 1;
    src = src + 1;
    goto start;
  end: *dest = '\0';
    return;
}

// Problem 4.
// return the number of odd numbers in x
// int count_odds(int x[ ], int len) { // array syntax not allowed
//   int answer = 0;
//   int i;
//   for (i=0; i<len; i++)             // for loops not allowed
//     if (x[i]%2 == 1)                // array syntax not allowed
//                                     // % not allowed
//       answer++;                     // ++ not allowed
//   return answer;
// }

int count_odds(int *x, int len) {
  int answer = 0;
  int i = 0;
  if ((*x & 1) == 1) goto odd;
  start: if(i >= len) goto end;
    i = i + 1;
    x = x + 1;
    if ((*x & 1) == 1) goto odd;
    goto start;
  odd: answer = answer + 1;
    goto start;
  end: return answer;
}

// Problem 5.
// compute x to the y power
// int power(int x, int y) {
//     int answer = 1;
//     int i;
//     for (i=0; i<y; i++)  // for loops not allowed
//        answer *= x;
//     return answer;
// }

int power(int x, int y) {
  int answer = 1;
  int i = 0;
  L1: if (i>=y) goto L2;
    answer = answer * x;
    i = i + 1;
    goto L1;
  L2: return answer;
}


