#include <stdio.h>

void read_array(int x[], int len) {
  int i;
  for (i=0; i<len; i++)
    // scanf("%d", &x[i]);
    scanf("%d", (x+i));
}

int main() {
  printf("Type 3 numbers\n");
  int x[3];
  read_array(x, 3);
  int i;
  for (i=0; i<3; i++)
    printf("%d\n", x[i]);
}
