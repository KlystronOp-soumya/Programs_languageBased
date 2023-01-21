#include <stdio.h>
void add(int a,int b)
{
    printf("add=%d\n",a+b);
}
void sub(int a,int b)
{
    printf("sub=%d\n",a-b);
}
void mul(int a,int b)
{
    printf("mul=%d\n",a*b);
}

void main()
{
    void (*fun[])(int,int)={add,sub,mul};
    int ch;
    int a,b;
    printf("Enter a and b\n");
    scanf("%d%d",&a,&b);
    printf("Enter the operation\n");
    scanf("%d",&ch);
    if(ch>2)
    printf("Wrong Input\n");
    else
    (*fun[ch])(a,b);
}