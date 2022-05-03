#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 int a = 3 , b = 4;
 //swap not using any third var

 a= a^b ;
 b=a^b;
 a=a^b;
return 0;
}