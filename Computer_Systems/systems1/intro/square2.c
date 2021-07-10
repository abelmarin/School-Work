#include <stdio.h>

int main() {
  int x;
  printf("Type an integer\n");
  scanf("%d", &x);
  int sq = square2(x);
  printf("%d squared is %d\n", x, sq);
}
int square2(int x) {
  x *= x;  // does not matter that the variable name in main
           // is the same as in square2
  return x;
}
