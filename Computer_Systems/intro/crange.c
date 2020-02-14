#define MAX 1
#include <stdio.h>

void range(int r[], int len) {
  int i;
  for (i=0; i<len; i++)
    r[i] = i;
}

void read_array(int arr[], int len) {
  printf("Please type %d numbers with blanks in between\n", len);
  int i;
  for (i=0; i<len; i++)
    scanf("%d", &arr[i]);

}

int main() {
  int r[MAX];
  range(r, MAX);
  int i;
  for (i = 0; i<MAX; i++)
    printf("%d ", r[i]);
  printf("\n");
  read_array(r,MAX);
  for (i = 0; i<MAX; i++)
    printf("%d ", r[i]);
  printf("\n");
}
	   
