#include <stdio.h>
#include <string.h>

// this one is wrong 
void *f(int x, char word[]) { 
  switch(x) { 
  case 1:  strcpy(word, "one"); // not ans = "one"
  case 2:  strcpy(word, "two"); 
  case 3:  strcpy(word, "three"); 
  default: strcpy(word, "greater than three"); 
  } 
} 

int main() {
  char word[20];
  int i;
  for (i=1; i<=4; i++) {
    f(i, word);
    printf("%d %s\n", i, word);
  }
}
