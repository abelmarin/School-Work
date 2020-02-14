#include <stdio.h>

int main() {
  int arr[5];
  int i;
  for (i=0; i<5; i++)
    arr[i] = i*10;
  for (i=4; i>=0; i--)
    printf("%d\n", arr[i]);
}
