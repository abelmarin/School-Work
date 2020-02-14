#include <stdio.h>

// problem 3
int powers_of_2(int x, int power2[]) {
    
    int i;
    int start = 1;
    power2[0] = 1;
    for (i = 1; start < x; i++) {
        start *= 2;
        power2[i] = start;
    }
    for (i = 0; power2[i] < x; i++) {
        printf("%d\n", power2[i]);
    }
}  

// problem 4
void to_upper_case(char *s){
    int i=0;
    while(s[i] != '\0'){
        if(s[i]>= 'a' && s[i] <= 'z' ){
            s[i] = s[i]-32;
        }
        i++;
    }
}

// problem 7
int assembly_function( x, y) {
  return x + y;
}

int main() {
    char s1[5] = "abel";
    int power2[10] = {};
    powers_of_2(33, power2);
    to_upper_case(s1);
    int x = assembly_function(1,2);
    printf("%s %d\n", s1, x);
}