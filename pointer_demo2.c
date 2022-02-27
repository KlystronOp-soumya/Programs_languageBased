#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int x; //definign a variable of Integer type
    int *j ; //defining a pointer variable which points to Integer type data

    j = &x; //stores the address of x;
    
    /*
      *(&x) => *j
    */
    printf("Address of x = %u\n",&x) ; //Address
    printf("Value of x is %d\n",x); //value

    printf("Value at that address %u is %d" ,&x,*(&x));
    printf("\n\n");
    printf("Address of j = %u\n",&j) ; //Address

    printf("Value of j is %d\n",j); //value

    printf("Value at that address %u is %d\n" ,&j,*(&j));

    printf("Value pointed by J is : %d\n",*j);//j=&x

    printf("Value in x is : %d\n",x);
    return 0;
}
