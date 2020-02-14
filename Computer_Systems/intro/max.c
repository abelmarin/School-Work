#include <stdio.h>

int max(int x[], int len) {
  int answer = x[0];
  int i; 
  for (i=1; i<len; i++)
    if (x[i] > answer)
      answer = x[i];
  return answer;
}

int main() {
  int x[] = {2, 1, 4, 6, 3, 5};
  printf("%d\n", max(x, 6));
}
    
