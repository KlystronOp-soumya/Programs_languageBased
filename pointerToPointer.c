#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int i =3,*j,**k ;

    j=&i;
    k=&j;

    printf("Address of i = %u\n",&i) ;
    printf("Address of j = %u\n",&j) ;
    printf("Address of k = %u\n",&k);

    printf("Address of i using j = %u \n", j); //&i
    printf("Address of j using k = %u\n",k) ; //&j
    printf("Address of i using k = %u\n", *k) ;//&i

    printf("Value of i = %d\n",i) ;
    printf("value of i = %d\n",*j) ;
    printf("Value of i = %d\n",**k);

    return 0;
}
