/*
Abel Marin
*/

/* CSC 373 Winter 2020 Prof Lytinen
   Homework assignment 2.  Write the 5 functions
   below as specified in the homework write-up.  You should write
   your code in the hw2.c file and then submit it to D2L when you
   are done.  Your hw2.c file should should NOT have a main function, 
   as I will test your code using my own main function.  You are 
   not allowed to use the C string library <string.h>), which contains 
   implementations of functions that are similar to the problems. 
*/
#include <stdio.h>

// 1.
// returning 0 means that str1 and str2 don't match character-by-character
// returning a nonzero int means that str1 and str2 do match.
// write in pointer syntax
int streql373(char *str1, char *str2) {
  int i;
  for (i = 0; *str1 != '\0'; i++) {
    str1++; str2++;
    if (*str1 != *str2) 
      return 0;
  }
	return 1;
}

// 2.
// This time, returning 0 means that str1 and str2 match character-by-character
// returning a positive int means str1 ls lexicagraphically before str2
// returnnig a negative int means str2 is before str1
int strcmp373(char str1[], char str2[]) {
  int i;
  for (i = 0; str1[i] != '\0'; i++) {
    if (str1[i] != str2[i])
      return str1[i] - str2[i];
  }
  return str1[i] - str2[i];
}

// 3.
// This is the string concatenation function.  It returns a C string
// which represents the concatenation of str1 and str2.  Remember
// there is '\0' at the end of str1 prior to concatentation.  It should 
// not be included in the concenated result.  Also, the concenation should 
// fit into the str1 array (although your code shouldn't check -- how
// could it if it wanted to?)  After str2 there should be a '\0'
// to represent the end of the concatenated string.  Use point synax.
char *strcat373(char *str1, char *str2) {
  int i = 0;
  int j = 0;
  while (*(str1+i) != '\0') {
    i++; 
  }
    
  while (*(str2+j) != '\0') {
    *(str1+i) = *(str2+j);
    i++; j++; 
  }
  *(str1+i) = '\0';
  return str1;

}

// 4.
// return a substring of str, in which the first char is c
// and the other chars in the substring are the remaining
// chars in str beyond c.  If c does not appear in str,
// return 0.
char *strchr373(char str[], char c) {
  int i = 0;
  for (i = 0; str[i] != '\0'; i++) {
    if(str[i] == c)
    return &str[i];
  }
  return 0;
}

// 5.
// copy the contents of src into dest, but only to a max
// of len characters (presumably len is the length of dest)
// Use array syntax
char *strncpy373(char dest[], char src[], int len) {
  int i;
  for (i = 0; i != len; i++) {
    dest[i] = src[i];
  }
  return dest;
}



























