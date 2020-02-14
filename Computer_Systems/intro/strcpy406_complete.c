#include <stdio.h>

void strcpy406_v1(char dest[], char src[]) {
  int i;
  for (i=0; src[i] != '\0'; i++)
    dest[i] = src[i];
  dest[i] = '\0';
}

void strcpy406_v2(char *dest, char *src) {
  int i;
  for (i=0; *src != '\0'; i++)
    *dest++ = *src++;
  *dest = '\0';
}

int main() {
  char input[100];
  char copy[100];
  printf("Type a word\n");
  scanf("%s", input);
  strcpy406_v1(copy, input);
  printf("strcpy406_v1 = %s\n", copy);
  strcpy406_v2(copy, input);
  printf("strcpy406_v2 = %s\n", copy);
}
