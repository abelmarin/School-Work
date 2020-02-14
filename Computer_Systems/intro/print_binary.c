#include <stdio.h>

void print_binary(int x) {
  // makes this machine-independent
  int size = (sizeof x) * 8;  
  // 2's complement
  if (x<0) printf("1");
  else printf("0");
  int i;
  int mask = 1;
  //  for (i=1; i<size-1; i++)
  //    mask = mask << 1;
  mask = mask << (size-2);
  for (i=1; i<size; i++) {
    //    printf("%d\n", mask);
    if (x&mask) printf("1");
    else printf("0");
    mask = mask >> 1;
  }
}

int main() {
  printf("Enter an integer\n");
  int i;
  scanf("%d", &i);
  print_binary(i);
  printf("\n");
}
