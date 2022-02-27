#include<stdio.h>
#include<stdlib.h>

int fact_itr(int );
int fact_recr(int );

int main(int argc, char const *argv[])
{
    int n;
    scanf("%d",&n);
    printf("%d\n",fact_itr(n));
    printf("%d",fact_recr(n));
    return 0;
}

int fact_itr(int n)//5
{
    int product = 1;
   for(int i = 1 ;i<=n ;++i)
   {
       product*= i;
   }
    return product;
}

int fact_recr(int n)
{
    int product=1 ;
    if(n==0)
     return 1;
    
    return n*fact_recr(n-1);
}