#include <stdio.h>

void incr(int* x) { 
  *x += 1; // now *x is 1 more than it was 
} 

int main() { 
  int y = 1; 
  incr(&y); // y is now 2 
  printf("%d\n", y); 
} 
