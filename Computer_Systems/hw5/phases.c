#include <stdio.h>
#include <string.h>
#include "support.h"

void phase_1(char *s, int x) {
  int ulen = strlen(user_id);
  if (ulen < x) x = ulen;
  int i;
  for (i=0; i<x; i++)
    if (user_id[i] != s[i])
      break;
  if (i != x || s[i] != '\0') explode_bomb();
}

// c should be the xth character of the alphabet 
// (c - 'x' = 'a').  a should be the ASCII for c
// in decimal, and b should be the ASCII for c in hex
 
void phase_2(char *s, int x) { 
  char c, right_c = 'a' + x;
  int a, b;
  sscanf(s, "%c %d %x", &c, &a, &b);
  if (c != right_c)
    explode_bomb();
  if (a != c || a != b)
    explode_bomb();
}

// the array should be a sequence in which each item
// is double the previous item.  The sequence begins
// with x

void phase_3(char *s, int x) {
  int numbers[6];
  read_six_numbers(s, numbers);
  if (numbers[0] != x) explode_bomb();
  int i;
  for (i=1; i<6; i++)
    if (numbers[i-1]+i != numbers[i]) explode_bomb();
}

// s should be a substring of "computer systems".
// the substring begins at s[x] and ends at s[x+x]

void phase_4(char *s, int x) {
  char phrase[20] = "computer systems";
  strcpy(phrase, &phrase[x]);
  phrase[x] = '\0';
  if (strcmp(s, phrase) != 0)
    explode_bomb();
}

// s should be a decimal input, equal to the sum of
// factorials from 1 to x.

void phase_5(char *s, int x) { 
  int sum_fact;
  sscanf(s, "%d", &sum_fact);
  //  printf("%d %d\n", sum_fact, x);
  int total = 0;
  int i;
  for (i=1; i<=x; i++)
    total += factorial(i);
  if (total != sum_fact) explode_bomb();
}

int factorial(int x) {
  int ans = 1;
  int i;
  for (i=2; i<=x; i++)
    ans *= i;
  return ans;
}


