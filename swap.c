#include<stdio.h>
#include<stdlib.h>

void swap(int a,int b)
{
    printf("Initially value of a=%d and b=%d\n",a,b);
    int t = a;
    a=b;
    b=t;
    printf("after swapping value of a=%d and b=%d\n",a,b);
}

void swap_pointer(int *a,int *b) //takes address
{
    int t = *a;
    *a = *b; //pointer arithmetic
    *b = t;
}
int main(int argc, char const *argv[])
{
    /* code */
    int a =2 ,b=3;
    swap(a,b);
     printf("after swapping value of a=%d and b=%d\n",a,b);
     int *j = &a, *k = &b;
      swap_pointer (*j,*k); //explain this behaviour
    //swap_pointer (&a,&b);
     
      printf("after swapping value of a=%d and b=%d\n",a,b);
    return 0;
}
