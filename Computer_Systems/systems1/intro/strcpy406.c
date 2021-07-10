#include <stdio.h>

// array syntax
void strcpy406_v1(char dest[], char src[]) {
  int i;
  for (i=0; src[i] != '\0'; i++)
    dest[i] = src[i];
  dest[i] = '\0';
}

// pointer syntax
void strcpy406_v2(char *dest, char *src) {
  for ( ; *src != '\0'; src++)
    *dest++ = *src;
  *dest = '\0';
}

int main() {
  char dest[50];
  char src[] = "CSC 406 Spring 2017";
  strcpy406_v1(dest, src);
  printf("copy is %s\n", dest);
  strcpy406_v2(dest, src);
  printf("copy is %s\n", dest);


}
