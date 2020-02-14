#include <stdio.h>

int main() { 
  char s1[] = "off-campus and on-campus housing";
  int h = countHyphens2(s1); 
  printf("%d\n", h);
}

int countHyphens2(char* s) { 
  int count = 0; 

  for(; *s != '\0'; s++) { 
    if (*s == '-')
      count++; 
  } 
  return count; 
}
