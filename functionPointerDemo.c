#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

int multipl(int a , int b, int c)
{
    return a*b*c ;
}
 
int main(int argc,char*argv[])
{

//decalring a function pointer
int (*multipl_ptr)(int , int , int) ;
multipl_ptr = multipl ; //assigning the address 

int result = multipl(1,2,3) ;
int result2 =(multipl_ptr)(1,2,3) ;
printf("%d" , result2) ;
return 0;
}