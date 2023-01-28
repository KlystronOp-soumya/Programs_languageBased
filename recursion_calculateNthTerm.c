/*
  S(n)=a n=1
      =b n=2;
      =c n=3;
      =S(n-1)+S(n-2)+S(n-3)
*/
#include<stdio.h>
#include<stdlib.h>

int calulate_nth_term(int n,int a,int b,int c)
{
    //n is term number
    if(n==1)
    return a;
    if(n==2)
    return b;
    if(n==3)
    return c;
    
    return (calulate_nth_term(n-1,a,b,c)+calulate_nth_term(n-2,a,b,c)+calulate_nth_term(n-3,a,b,c));

}
int main(int argc,char *argv[])
{
    int a,b,c,n;
     n=atoi(argv[1]);//term number
     a=atoi(argv[2]);
     b=atoi(argv[3]);
     c=atoi(argv[4]);

     printf("%d",calulate_nth_term(n,a,b,c));
     return 0;
     
}