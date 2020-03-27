#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "support.h"

//extern char *user_id;
//extern int ulength;


int explode_bomb() {
  printf("Boom!!!\n");
  exit(1);
}

int read_six_numbers(char *s, int x[]) {
  int *p0 = &x[0];
  int *p1 = &x[1];
  int *p2 = &x[2];
  int *p3 = &x[3];
  int *p4 = &x[4];
  int *p5 = &x[5];
  return sscanf(s, "%d%d%d%d%d%d", p0, p1, p2, p3, p4, p5);
}

int hash(int indices[], int len) {
  int sum=0;
  int idx;
  int i;
  for (i=0; i < len; i++) {
    idx = indices[i];
    if (ulength < idx)
      idx = ulength;
    sum = 13*sum + user_id[idx]; }
  return sum;
}

int hash1() {
  int indices[] = {2, 4, 3, 5};
  return 5 + hash(indices,4)%3;
}

int hash2() {
  int indices[] = {0, 2, 1, 3, 4};
  return 3 + hash(indices,5)%5;
}

int hash3() {
  int indices[] = {4, 1, 0, 5, 2};
  return 1 + hash(indices,4)%5;
}

int hash4() {
  int indices[] = {1, 2, 4, 6, 3};
  int i=6;
  int h;
  for (h = 2 + hash(indices, 5)%i; h != 0; h--,i--)
    return h;
}

int hash5() {
  int indices[] = {3, 2, 1, 0};
  return 3 + hash(indices, 4)%5;
}

int alphanumeric (char c) {
  return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
        (c >= '0' && c <= '9') || c == ' ';
}

void receive_input(char *input, size_t len) {
  getline(&input, &len, stdin);
  int end = strlen(input);
  input[end-1] = '\0';
}

