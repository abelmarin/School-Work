#include <stdio.h>
#include <string.h> // BUT YOU'RE NOT ALLOWED TO USED BUILT-IN
                    // STRING FUNCTIONS IN YOUR hw2.c CODE
#include "hw2.c"

int main() {
	char word1[7] = "bin", 
		 word2[] = "bag",
	     word3[25] = "computer", 
		 word4[] = "game",
	     word5[] = "area", 
		 word6[] = "area", 
		 word7[] = "are",
		 word8[7] = "bo",
		 word9[] = "ringer",
		 word10[7] = "bo";

	int  cmp1 = streql373(word1, word2),
	     cmp2 = streql373(word3, word4),
	     cmp3 = streql373(word5, word6),
	     cmp4 = streql373(word7, word6);
	printf("Test streql373\n");
	printf("%s %s = %d\n", word1, word2, cmp1);
	printf("%s %s = %d\n", word3, word4, cmp2);
	printf("%s %s = %d\n", word5, word6, cmp3);
	printf("%s %s = %d\n", word7, word6, cmp4);
	cmp1 = strcmp373(word1, word2),
	cmp2 = strcmp373(word3, word4),
	cmp3 = strcmp373(word5, word6),
	cmp4 = strcmp373(word7, word6);
	
	printf("\nTest strcmp373\n");
	printf("%s %s = %d\n", word1, word2, cmp1);
	printf("%s %s = %d\n", word3, word4, cmp2);
	printf("%s %s = %d\n", word5, word6, cmp3);
	printf("%s %s = %d\n", word7, word6, cmp4);
	
	printf("\nTest strcat373\n");
	printf("%s %s = ", word1, word2);
	printf("%s\n", strcat373(word1, word2));
	printf("%s ' ' %s = ", word3, word4);
	strcat373(word3, " ");
	strcat373(word3, word4);
	printf("%s\n", word3);
	printf("%s %s = ", word8, word7+1);
	printf("%s\n", strcat373(word8, word7+1));
	
	printf("\nTest strchr373\n");
	char s[ ] = "abcbc";
	printf("%s %c = ", s, 'b');
	printf("%s\n", strchr373(s, 'b'));   // prints bcbc
	printf("%s %c = ",  s, 'c'); 
	printf("%s\n", strchr373(s, 'c'));   // prints cbc
	printf("%s %c = ",  s, 'd'); 
	printf("%d\n", strchr373(s, 'd'));    // prints (null) or 0
	
	printf("\nTest strncpy373\n");
	char s1[] = "comp";
	char s2[] = "systems";
	printf("%s %s = ", s1, s2);
	strncpy373(s1, s2, 4);
	printf("%s\n", s1);
}
