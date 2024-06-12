#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

//defining the int pointers
typedef int *INT_PTR ;
 
int main(int argc,char*argv[])
{
 INT_PTR p1 , p2 ;
 int a = 3 , b = 4 ;
 p1=&a ;
 p2=&b ;
 printf("%d %d" , *p1 , *p2) ;
return 0;
}