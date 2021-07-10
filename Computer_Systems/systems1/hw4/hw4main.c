/* CSC 373 Spring 2019 -- Lytinen */
/* Homework 4 */

#include <stdio.h>
#include "hw4.c"

int main() {
  int arr[] = {1,2,5,4,3};
  reverse(arr, 5);
  int i;
  printf("Reverse is ");
  for (i=0; i<5; i++)
    printf("%d ", arr[i]);
  printf("\n");
  printf("Max is %d\n", max(arr, 5));
  char course[] = "csc 373";
  char course_copy[50];
  strcpy373(course_copy, course);
  printf("Copy is %s\n", course_copy);
  printf("# of odds is %d\n", count_odds(arr, 5));
  printf("%d to the power of %d is %d\n", 3, 4, power(3, 4));
}
