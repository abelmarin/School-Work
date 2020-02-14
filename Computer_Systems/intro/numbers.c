#include <stdio.h>

int main() {
  int x=1; long y=1; short z=1; char c=1;

  int largest_int; long largest_long;
  short largest_short; char largest_char;

  while (x > 0) {
    largest_int = x;
    x *= 2;   }
  printf("Largest int multiple of 2: %d\n", largest_int);
  printf("%d * 2: %d\n\n", largest_int, x);
  while (y > 0) {
    largest_long = y;
    y *= 2;  }
  printf("Largest long multiple of 2: %ld\n", largest_long);
  printf("%ld * 2: %ld\n\n", largest_long, y);

  while (z > 0) {
    largest_short = z;
    z *= 2;  }
  printf("Largest short multiple of 2: %d\n", largest_short);
  printf("%d * 2: %d\n\n", largest_short, z);

  while (c > 0) {
    largest_char = c;
    c *= 2;
  }
  printf("Largest char multiple of 2: %d\n", largest_char);
  printf("%d * 2: %d\n", largest_char, c);
}
