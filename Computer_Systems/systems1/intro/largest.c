#include <stdio.h>

void largest() {
  long w = 1;
  long previous_w;
  int x = 1;
  int previous_x;
  short y = 1;
  short previous_y;
  char z = 1;
  char previous_z;
  while (w > 0) {
    previous_w = w;
    w = (w << 1) | 1;
  }
  while (x > 0) {
    previous_x = x;
    x = (x << 1) | 1;
  }
  while (y > 0) {
    previous_y = y;
    y = (y << 1) | 1;
  }
  while (z > 0) {
    previous_z = z; 
    z = (z << 1) | 1;
  }

  printf("Biggest long: %ld\n", previous_w);
  printf("Biggest int: %d\n", previous_x);
  printf("Biggest short %d\n", previous_y);
  printf("Biggest byte %d\n", previous_z);
}

int main() {
  largest();
}
