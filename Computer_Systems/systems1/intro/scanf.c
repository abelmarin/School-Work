#include <stdio.h>

int main() { 
  float f;
  float *fptr = &f;
  int x; 
  printf("Type a floating point number and an integer\n"); 
  scanf("%f%d", fptr, &x);
  printf("You typed %f %d\n", f, x);
}
