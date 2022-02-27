#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int x = 13;

    printf("Address of x = %u\n",&x) ; //Address
    printf("Value of x is %d\n",x); //value

    printf("Value at that address %u is %d" ,&x,*(&x));

  int j = *(&x); // &i


    return 0;
}
