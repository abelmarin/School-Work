#include <stdio.h>

int strlen373_v1(char str[]) {
  int i;
  for (i=0; str[i]!='\0'; i++);
  return i;
}

int strlen373_v2(char *str) {
  char *other = str;
  for ( ; *str!='\0'; str++);
  return str - other;
}

/*
int strlen373_v2(char *str) {
  int i;
  for (i=0; *(str+i)!='\0'; i++);
  return i;
}
*/

char *strcpy373(char dest[], char src[]) {
  int i;
  for (i=0; src[i] != '\0'; i++)
    dest[i] = src[i];
  dest[i] = '\0';
  return dest;
}

char *strcpy373v2(char *dest, char *src) {
  char *ans = dest;
  for (; *src!='\0'; src++, dest++)
    *dest = *src;
  *dest = '\0';
  return ans;
}

int main() {
  char s1[] = "computer";
  char s2[] = "science";
  int len1 = strlen373_v1(s1);
  int len2 = strlen373_v2(s2);
  printf("%s length = %d\n%s length = %d\n", s1, len1, s2, len2);
  strcpy373(s1,s2);
  strcpy373v2(s2,s1);
  printf("%s %s\n", s1, s2); 
}
