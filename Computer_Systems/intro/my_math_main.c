#include <stdio.h>
#include "my_math.h"

int main() {
  int x = 2, y = 3;
  double d = 2.75;
  printf("%d squared = %d\n", x, square(x));
  printf("%d times %d = %d\n", x, y, multiply(x,y));
  printf("%f truncated is %d\n", d, truncate(d));
}
