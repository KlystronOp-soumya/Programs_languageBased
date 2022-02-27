/*Return Demo*/
#include<stdio.h>
#include<stdlib.h>

/*prototypes*/
int divide(int a,int b);//this performs addition of two inetegers
void display(int);// this shows the result

int main(int argc, char const *argv[])
{
    int a,b;
    scanf("%d%d",&a,&b);
    int res = divide(a,b);

    if(res !=-1)
     display(res);
    else
        printf("ArithmaticException");

    return 0;
}

int divide(const int a ,const int b)
{
    if(b == 0) //handle exception
        return -1;
        
    else
     return a/b;

}

void display(int res)
{
    printf("Result is: %d",res);
}