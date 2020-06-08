#include <stdio.h>
#include "print_binary.c"

int main() {
  int x,y;
  unsigned int z;
  printf("Enter 2 numbers\n");
  scanf("%d %d", &x, &y);
  z = x;
  printf("\n\nx =      ");
  print_binary(x);
  printf("\n~x =     ");
  print_binary(~x);
  printf("\nx << 1 = ");
  print_binary(x << 1);
  printf("\nx << 2 = ");
  print_binary(x << 2);
  printf("\nx << 3 = ");
  print_binary(x << 3);
  printf("\n\nx in decimal = %d\n", x);
  printf("~x in decimal    = %d\n", ~x);
  printf("x << 1 in decimal = %d\n", x << 1);
  printf("x << 2 in decimal = %d\n", x << 2);
  printf("x << 3 in decimal = %d\n", x << 3);
  printf("\ny =      ");
  print_binary(y);
  printf("\n~y =     ");
  print_binary(~y);
  printf("\ny >> 1 = ");
  print_binary(y >> 1);
  printf("\ny >> 2 = ");
  print_binary(y >> 2);
  printf("\ny >> 3 = ");
  print_binary(y >> 3);
  printf("\n\ny in decimal = %d\n", y);
  printf("~y in decimal    = %d\n", ~y);
  printf("y >> 1 in decimal = %d\n", y >> 1);
  printf("y >> 2 in decimal = %d\n", y >> 2);
  printf("y >> 3 in decimal = %d\n", y >> 3);
  printf("\n\nz =       ");
  print_binary(z);
  printf("\n~z =      ");
  print_binary(~z);
  z = ~z;
  printf("\n~z >> 1 = ");
  print_binary(z >> 1);
  printf("\n~z >> 2 = ");
  print_binary(z >> 2);
  printf("\n~z >> 3 = ");
  print_binary(z >> 3);
  printf("\n\n~z in decimal = %u\n", z);
  printf("~z >> 1 in decimal = %u\n", z >> 1);
  printf("~z >> 2 in decimal = %u\n", z >> 2);
  printf("~z >> 3 in decimal = %u\n\n", z >> 3);
}
