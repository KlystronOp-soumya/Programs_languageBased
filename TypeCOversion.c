#include<stdio.h>
#include<stdlib.h>

//type conversion
int main(int argc, char const *argv[])
{
    int a,b;
    float c;

    c= 2.5;
    printf("c=%f",c);
    c=3;
    printf("c=%f",c);//3.0

    a=2;
    printf("a=%d\n",a);//2

    a=1.3;
    printf("a=%d\n",a);//1
    printf("a=%f\n",a);//1

    printf("%f\n",2/5);
    printf("%f\n",5/2);
    float f = 5/2;
    printf("%f\n",f);
    printf("%d\n",f);
    printf("%f\n",2.0/5);
    printf("%f\n",5.0/2);
    int i = 5/2;



    return 0;
}
