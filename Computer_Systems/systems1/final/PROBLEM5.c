#include <stdio.h>

int f(int i) {
  return (1 << i);
}

int main() {
  int i;
  for (i=0; i<8; i++)
    printf("%#x\n", f(i));
}	
