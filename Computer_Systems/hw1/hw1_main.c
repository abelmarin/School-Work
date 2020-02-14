// CSC 373 Winter 373 Prof. Lytinen
// Homework assignment 1 test file

// this code tests the 6 functions that
// you will write for homework 1.  It is NOT
// a thorough test, so you should add test cases
// to this in order to convince yourself that
// your code is correct.

// I may use a different hw1_test.c file when I
// test your code for grading purposes.

#include <stdio.h>
// includes your hw1.c file (not from C library)
// note " " instead of < >
#include "hw1.c"  

void test_p1() {
   printf("\np1\n");
   int x, y;
   printf("type two ints\n");
   scan_ints(&x, &y);
   print_ints(x, y);
}

void test_p2() {
   printf("\np2\n");
   int x = 2;
   int *xptr = &x;
   printf("pow_xy %d 3 ", x);
   pow_xy(xptr, 3);
   printf("= %d\n", x);
}

void test_p3() {
   printf("\np3\n");
   int new_degrees;
   char new_scale;
   convert_temp(32, 'F', &new_degrees, &new_scale);
   printf("32 F is %d %c\n", new_degrees, new_scale);
   convert_temp(10, 'C', &new_degrees, &new_scale);
   printf("10 C is %d %c\n", new_degrees, new_scale);
}

void test_p4() {
   printf("\np4\n");
   int numbers[5];
   init_array(numbers, 5, 2);
   int i;
   for (i=0; i<5; i++)
      printf("%d ", numbers[i]);
   printf("\n");
}


void test_p5() {
    printf("\np5\n");
	int phone[] = {3, 1, 2, 3, 6, 2, 6, 1, 0, 6}; 
	reverse_numbers(phone, 10);
	int i;
	for (i=0; i<10; i++)
		printf("%d ", phone[i]);
	printf("\n");
}


int main() {
	test_p1();
	test_p2();
	test_p3();
	test_p4();
	test_p5();
}

