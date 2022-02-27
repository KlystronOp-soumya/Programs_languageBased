#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int a=5,b=10;
    int c = a>b;

    if(c == 0)
     printf("False");
    else
      printf("True");

    if(a>b)
     printf("%d is greater than %d",a,b);
    else
      printf("%d is greater than %d",b,a);

    (a>b)? printf("%d is greater than %d",a,b) :  printf("%d is greater than %d",b,a);
   

    int num = (a>b)? a :  b;
    printf("Greater number is: %d",num);
    return 0;
}
