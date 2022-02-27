#include<stdio.h>
#include<stdlib.h>

//global
int *c, *d ;

void calc(int a,int b)
{
    *c = a+b;
    *d = a-b;
}

int main(int argc, char const *argv[])
{
    /* code */
    int a =3,b=2;
    int e,f;
    c=&e;
    d=&f;

    calc(a,b) ;
    printf("Sum = %d\n",*c);
    printf("Sum = %d\n",*d);
     printf("Sum = %d\n",e);
    printf("Sum = %d\n",f);

    return 0;
}
