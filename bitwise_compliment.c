#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 
 unsigned char ch = 32 ;
 unsigned char c;

 c= ~ch ;
 printf("%d ",c) ;//int
 printf("%X ",c) ;//Hexa
  
return 0;
}