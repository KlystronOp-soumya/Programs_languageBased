#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 int *ar[3] ; //array of pointers
 int  i =1,j=2,k=3 ;
 ar[0] = &i;
 ar[1] = &j;
 ar[2] = &k;

 for(int m=0;m<3;++m)
 {
     printf("%d ", *(ar[m])) ;//ar[m] gives the address
 }
return 0;
}