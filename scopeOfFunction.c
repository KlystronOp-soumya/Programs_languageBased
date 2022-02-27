#include<stdio.h>
#include<stdlib.h>

/****/
void fun1 (int);
void fun2();

int main(int argc, char const *argv[])
{
    int a=11;
    fun1(a);
    return 0;
}
void fun1(int a)
{
    int i = 10;
    
    printf("a=%d\n",a);
    fun2(i);

}

void fun2(int j)
{
    printf("j=%d\n",j);
}
