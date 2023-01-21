#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
float dollar_inr = 81.26 ;
 
int main(int argc,char*argv[])
{
    
    int a, b;
    float average;
    int sum;
    char ch='A';//single char
    char name[]="Abhishek";//string

printf("Hello World\n");
printf("Enter two numbers a and b:");
scanf("%d%d",&a,&b);
sum = a+b ;
printf("Sum of %d and %d is %d",a,b,sum) ;
return 0;
}