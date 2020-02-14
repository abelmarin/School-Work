#include <stdio.h>
#include <string.h>

int main() {
  char s1[8] = "csc 406";
  char s2[15] = "c language";
  char s3[30];
  // string length, returns 7 not 8
  int len = strlen(s1);
  // string comparison, returns # of difference
  // in lexicographic order
  int diff = strcmp(s1, s2);
  if (diff == 0) // normally false, but in this case means
                 // the strings are equal
    printf("%s and %s are the same\n", s1, s2);
  else if (diff < 0)
    printf("%s is before %s\n", s1, s2);
  // this one will print
  else printf("%s is before %s\n", s2, s1);
  strcpy(s3, s1);
  strcat(s3, " ");
  strcat(s3, s2);
  printf("%s\n", s3); // prints csc 406 c language
  char s4[] = "406";
  int i = atoi(s4);
  printf("%d\n", i); // prints 406
}

