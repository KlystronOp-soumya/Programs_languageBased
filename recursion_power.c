#include<stdio.h>
#include<stdlib.h>

/* int power(int base,int index)
{
   if(index==0)
   return 1;
   if(index==1)
   return base;
   else
   return (base*power(base,index-1));
} */

 int fast_power(int base,int index)
{
   if(index==0)
   return 1;
   if(index%2==0)
   return fast_power(base*base,index/2);

   return base*fast_power(base,index-1);
} 

int main(int argc,char *argv[])
{
    int base,index;
    base=atoi(argv[1]);
 index=atoi(argv[2]);
    //printf("%d^%d=%d",base,index,power(base,index));
    printf("%d^%d=%d",base,index,fast_power(base,index));

    return 0;

}