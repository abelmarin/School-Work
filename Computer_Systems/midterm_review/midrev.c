#include <stdio.h>

void min_and_max(int n[], int len, int *minptr, int *maxptr) {
  *minptr = n[0];
  *maxptr = n[0];
  int i;
  for (i=1; i<len; i++) {
    if (n[i] < *minptr)
      *minptr = n[i];
    else if (n[i] > *maxptr)
      *maxptr = n[i];
  }
}

void swap_v1(int n1[], int n2[], int len) {
  int i;
  int temp;
  for (i=0; i<len; i++) {
    temp = n1[i];
    n1[i] = n2[i];
    n2[i] = temp;
  }
}

void swap_v2(int *n1, int *n2, int len) {
  int temp;
  int i;
  for (i=0; i<len; i++) {
    temp = *n1;
    *n1 = *n2;
    *n2 = temp;
    n1++;
    n2++;
  }
}

int index_of(int x, int n[], int len) {
  int i;
  for (i=0; i<len; i++)
    if (x == n[i])
      return i;
  return -1;
}

int cindex_of(char c, char *s) {
  int i;
  for (i=0; *(s +i) != '\0'; i++)
    if (c == *(s + i))
      return i;
  return -1;
}

char *first_x(int x, char letters[]) {
  char c = 'a';
  int i;
  for (i=0; i<x; i++) {
    letters[i] = c;
    c++;
  }
  letters[i] = '\0';
  return letters;
}

// change ith bit of x to be 1
char bit_on(char x, char i) {
  return x | (1 << i);
}

// change ith bit of x to be 0
char bit_off(char x, char i) {
  return x & ~(1 << i);
}

// Q 16
int f(int x, int y, int z) {
  int c;
  int a;
  if (x < y)
    c = 1;
  a = 0;
  if (y < z)
    a = 1;
  a = a & c;
  return a;
}


/* testing function for the coding problems on review */

// prints the numbers in an array
void print(int n[], int len) {
  int i;
  for (i=0; i<10; i++)
    printf("%d ", n[i]);
  printf("\n");
}

int main() {
  int numbers[] = {3, 1, 2, 3, 6, 2, 8, 0, 0, 0};
  int other_numbers[] = {2, 4, 6, 8, 10, 9, 7, 5, 3, 1}; 
  int *n = numbers;
  int min, max;
  int i;
  printf("\n");
  print(n,10);
  min_and_max(n, 10, &min, &max);
  printf("min is %d and max is %d\n", min, max);
  n = other_numbers;
  print(n,10);
  min_and_max(n, 10, &min, &max);
  printf("min is %d and max is %d\n\n", min, max);

  printf("Swap the arrays, version 1\n");
  printf("Before:\n");
  print(numbers, 10);
  print(other_numbers, 10);
  printf("After:\n");
  swap_v1(numbers, other_numbers, 10);
  print(numbers, 10);
  print(other_numbers, 10);
  printf("\nSwap the arrays, version 2\n");
  printf("Before:\n");
  print(numbers, 10);
  print(other_numbers, 10);
  printf("After:\n");
  swap_v2(numbers, other_numbers, 10);
  print(numbers, 10);
  print(other_numbers, 10);
  printf("\nTest index_of\n");
  print(numbers,10);
  printf("Look for 3: %d\n", index_of(3, numbers, 10));
  printf("Look for 8: %d\n", index_of(8, numbers, 10));
  printf("Look for 9: %d\n", index_of(9, numbers, 10));
  printf("\nTest cindex_of\n");
  char str[] = "computer";
  printf("Look for o: %d\n", cindex_of('o', str));
  printf("Look for r: %d\n", cindex_of('r', str));
  printf("Look for s: %d\n", cindex_of('s', str));
  printf("\nTest first_x\n");
  char buf[27];
  first_x(10,buf);
  printf("First 10 are %s\n", buf);
  printf("\nTest bit_on:  before %#hhx after %#hhx\n", 'a', bit_on('a',7));
  printf("\nTest bit_off:  before %#x after %#x\n", 'a', bit_off('a',0));
}
