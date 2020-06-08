#include <stdio.h>
#include <string.h>

char *f(int x, char word[]) {
  switch(x) { 
  case 1:  strcpy(word, "one");
    break; 
  case 2:  strcpy(word, "two");
    break; 
  case 3:  strcpy(word, "three");
    break; 
  default: strcpy(word, "greater than three");
    break; 
  } 
  return word;
} 

int main() {
  char word[20]; 
  int i;
  for (i=1; i<=4; i++)
    printf("%s\n", f(i, word));
}

