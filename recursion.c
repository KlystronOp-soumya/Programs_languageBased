#include<stdio.h>
#include<stdlib.h>

/*prototypes*/
void display_using_recursion(int);
void display_using_iteration(int);

int main(int argc, char const *argv[])
{
    display_using_iteration(5);
    printf("recur\n");
    display_using_recursion(1);
    return 0;
}

void display_using_iteration(int a)
{
    printf("Iter\n");
    for(int i =1 ;i<=a ;++i)
    {
        printf("%d\n",i);
    }
}

void display_using_recursion(int a)
{
    
    //mandetory break condition
    if(a == 5)
    {
        printf("%d\n",a);
        return;
    }
     
    
    printf("%d\n",a);
    ++a;
    display_using_recursion(a);

}