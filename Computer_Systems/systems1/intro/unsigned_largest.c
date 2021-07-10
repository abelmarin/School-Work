#include <stdio.h>

void largest() {
  unsigned long w = 1;
  unsigned long previous_w = 0;
  unsigned int x = 1;
  unsigned int previous_x = 0;
  unsigned short y = 1;
  unsigned short previous_y = 0;
  unsigned char z = 1;
  unsigned char previous_z = 0;
  while (w > previous_w) {
    previous_w = w;
    w = (w << 1) | 1;
  }
  while (x > previous_x) {
    previous_x = x;
    x = (x << 1) | 1;
  }
  while (y > previous_y) {
    previous_y = y;
    y = (y << 1) | 1;
  }
  while (z > previous_z) {
    previous_z = z; 
    z = (z << 1) | 1;
  }

  printf("Biggest long: %lu\n", previous_w);
  printf("Biggest int: %u\n", previous_x);
  printf("Biggest short %u\n", previous_y);
  printf("Biggest byte %u\n", previous_z);
}

int main() {
  largest();
}
