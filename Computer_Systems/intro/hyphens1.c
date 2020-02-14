#include <stdio.h>

int main() { 
  char s1[20] = "off-campus and on-campus housing"; 
  int h = countHyphens1(s1); 
  printf("%d\n", h);
}

int countHyphens1(char s[]) { 
  int count = 0; 
  int i; 
  for (i = 0; s[i] != '\0'; i++) { 
    if (s[i] == '-') 
      count++; } 
  return count; 
}
