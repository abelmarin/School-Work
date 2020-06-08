// Abel Marin CSC373

/* CSC 373 Winter 2020 Prof Lytinen
   Homework 1 due as specified on D2L
*/
#include <stdio.h>

//1
void scan_ints(int *x, int *y) {
    // This needs to be passed pointers because scanf 
    // needs to be passed pointers.
    scanf("%d%d", x, y);
}

void print_ints(int x, int y) {
    // This does not need pointers because you
    // would not want to print pointers with printf
    printf("%d %d\n", x, y);
}

//2
int pow_xy(int *xptr, int y) {
    int original = *xptr;
    int i;
    for (i = 1; i < y; i++) {
        *xptr *= original;
    }
    return *xptr;
}

//3
void convert_temp(int degree, char scale, int *other_degree, char *other_scale) {
	if (scale == 'F') {
        *other_degree = (degree - 32)*5/9;
        *other_scale = 'C';
    }
    else if (scale == 'C') {
        *other_degree = (degree * 9/5)+32;
        *other_scale = 'F';
    }
}

//4
int init_array(int array[ ], int len, int start_value) {
    int i;
    int total;
    for (i = 0; i < len; i++) {
        array[i] = i * start_value;
        total += array[i];
    }
	return total;
}

//5
void reverse_numbers(int nums[], int len) {
    int temp;
    int i;
    for (i = 0; i < len/2; i++) {
        temp = nums[i];
        nums[i] = nums[len-i-1];
        nums[len-i-1] = temp;
    }
}