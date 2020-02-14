#include <stdio.h> 
#include <string.h> 

int main() { 
  char s1[8] = "csc 406"; 
  char s2[15] = "c language";
  char s3[30];
  int len = strlen(s1);
  int diff = strcmp(s1, s2);
  if (diff == 0) // false
    printf("%s and %s are the same\n", s1, s2);
  else if (diff < 0) // also false
    printf("%s is before %s\n", s1, s2);
  // this one will print
  else printf("%s is before %s\n", s2, s1);
  strcpy(s3, s2);  // s3 is now "c language" 
  strcat(s3, " "); // concatenate " " at the end of s3 
  strcat(s3, s1);  // this produces "c language csc 406" 
  printf("%s\n", s3);
  // MAKE SURE YOU HAVE ENOUGH SPACE in s3
  char *s4 = "406"; 
  // converts a string to an integer
  int course_no = atoi(s4); 
  printf("%d\n", course_no);
}
