#include <stdio.h>
#include <string.h>

int main() {
  char op[10];
  char n1, n2;
  char n1_str[10], n2_str[10];
  while (1) {
    printf("Enter a bitwise expression\n");
    scanf("%s", n1_str);
    if (strcmp(n1_str, "q") == 0)
      return;
    scanf("%s %s", op, &n2_str);

    n1 = atoi(n1_str);
    n2 = atoi(n2_str);

    if (strcmp(op, "|") == 0) 
      printf("%d | %d = %d\n", n1, n2, n1|n2);
    else if (strcmp(op, "&") == 0)
      printf("%d & %d = %d\n", n1, n2, n1&n2);
    else if (strcmp(op, "^") == 0)
      printf("%d ^ %d = %d\n", n1, n2, n1^n2);
    else printf("Invalid operator\n");
  }
}
