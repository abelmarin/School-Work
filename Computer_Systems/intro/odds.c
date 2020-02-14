#include <stdio.h>

int power(int x, int y) {
  int answer = 1;
  int i;
  for (i=0; i<y; i++)
    answer *= x;
  return answer;
}

int count_odds(int x[ ], int len) {
  int answer = 0;
  int i;
  for (i=0; i<len; i++) 
    if (x[i]%2 == 1)
      answer++;
}

int pcount_odds(int *x, int len) {
  int end = *x+len;
  int answer = 0;
  while (x < end) {
      if (*(x)%2 == 1)
	answer++;

    }
  return answer;
}

int main() {
  printf("%d\n", power(4, 3));
  int number[] = {3, 1, 2, 3, 6, 2, 6, 1, 0, 6};
  printf("%d\n", count_odds(number, 10));
  printf("%d\n", pcount_odds(number, 10));
}
