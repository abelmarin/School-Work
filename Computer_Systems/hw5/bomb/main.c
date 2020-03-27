#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "support.h"

int main() {
  int x = 1;
  char c;
  //  char user_id[100];
  //  int ulength;
  printf("Type your user ID\n");
  receive_input(user_id, 100);
  ulength = strlen(user_id);
  char input[100];
  x = hash1();
  printf("Type your input for phase 1\n");
  printf("Your number is %d\n", x);
  receive_input(input, 100);
  if (strcmp(input,"skip") == 0)
    printf("Chicken\n");
  else phase_1(input, x);


  x = hash2();
  printf("Type your input for phase 2\n");
  printf("Your number is %d\n", x);
  receive_input(input, 100);
  if (strcmp(input,"skip") == 0)
    printf("Chicken\n");
  else phase_2(input, x);

  x = hash3();
  printf("Type your input for phase 3\n");
  printf("Your number is %d\n", x);
  receive_input(input, 100);
  if (strcmp(input,"skip") == 0)
    printf("Chicken\n");
  else phase_3(input, x);

  x = hash4();
  printf("Type your input for phase 4\n");
  printf("Your number is %d\n", x);
  receive_input(input, 100);
  if (strcmp(input,"skip") == 0)
    printf("Chicken\n");
  else phase_4(input, x);

  x = hash5();
  printf("Type your input for phase 5\n");
  printf("Your number is %d\n", x);
  receive_input(input, 100);
  if (strcmp(input,"skip") == 0)
    printf("Chicken\n");
  else phase_5(input, x);
}
