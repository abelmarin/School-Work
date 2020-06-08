#include <stdio.h>

int main() {
  int x = 5;
  char input[5];
  printf("Enter a string\n");
  scanf("%s", input);
  printf("You typed %c",*input);
}
