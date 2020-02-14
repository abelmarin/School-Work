#include <stdio.h>
#include "hw3.c"

int main() {
  int x;
  unsigned int y;
  int *xptr = &x;
  unsigned int *yptr = &y;
  long l;
  long *lptr = &l;
  unsigned long ul;
  unsigned long *ulptr = &ul;

  zero(xptr);
  printf("zero %d\n", x);
  maximum(ulptr);
  printf("max %#lx %lu\n", ul, ul);
  minimum(lptr);
  printf("min %#lx %ld\n", l, l);
  x = 3;
  negative(xptr);
  printf("negative %d\n", x);
  y = 0x12121212;
  set_byte(yptr, 2, 0x77);
  printf("%#x\n", y);
}
