#include <stdio.h>

int main() {
  int x[10];
  int i;
  for (i=0; i<10; i++)
    *(x+i) = 10*i; // this is "pointer arithmetic" 
  for (i=0; i<10; i++)
    printf("%d ", *(x+i)); //prints 0 10 20 30 ... 80 90 
  printf("\n");
  int y[10];
  for (i=0; i<10; i++)
    y[i] = 10*i;
  for (i=0; i<10; i++)
    printf("%d ", y[i]); //prints 0 10 20 30 ... 80 90 
  printf("\n");

}
