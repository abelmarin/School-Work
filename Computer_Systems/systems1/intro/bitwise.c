#include <stdio.h>
#include "print_binary.c"

int main() {
  int x,y;
  unsigned int z;
  printf("Enter 2 numbers\n");
  scanf("%d %d", &x, &y);
  printf("x in binary is ");
  print_binary(x);
  printf("\ny in binary is ");
  print_binary(y);
  printf("\n\nx & y = ");
  print_binary(x&y);
  printf("\nx | y = ");
  print_binary(x|y);
  printf("\nx ^ y = ");
  print_binary(x^y);
  printf("\n\nx = ");
  print_binary(x);
  printf("\n~x = ");
  print_binary(~x);
  printf("\n");
}
