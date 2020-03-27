#include <stdio.h>

// Problem 2
int mod(int x, int y) {
    while (x>=y) {
        x = x - y;
    }
    return x;
}

// Problem 3
int f(int x) {
    if (x == 1) return 1;
    if (x <= 0) return 0;

    x--;
    int y = f(x);

    if (y==0) return 1;
    else return 0;

}

int main (){
    printf("%d\n", mod(30,12));
    printf("%d\n", mod(3,12));
    printf("%d\n",f(3));
    printf("%d\n",f(0));
}
