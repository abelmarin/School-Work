#include <stdio.h>
#include <string.h>

int main() {
  char word1[100], word2[100]; 
  printf("Type 2 words\n");
  scanf("%s%s", word1, word2);
  printf("strcmp returns %d\n", strcmp(word1, word2));
}
 
