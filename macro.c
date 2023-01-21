#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include "myheader.h"

#define MAX_ELEM 100

#define ASUS
#define PI 3.14
#define AND &&
#define OR ||

#define CHECK_NEGATIVE (num < 0)

#define SQUARE(x) (x*x)
int main(int argc,char*argv[])
{
 int num = 1 ;
 printf("Area of the circle: %lf", PI* 5* 5) ;

 if( (1 AND 0) OR (1 AND 1))
    printf("Ans is not zero") ;
else
    printf("Ans is zero");

if(CHECK_NEGATIVE)
    printf("Negative");
else
    printf("+ve\n");

printf("%d\n",64/SQUARE(2)) ;

#ifdef ASUS
    printf("This is ASUS Lappy") ;
#endif
return 0;
}