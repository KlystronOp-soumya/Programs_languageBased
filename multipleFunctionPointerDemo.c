#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
/*
Function signature
*/

double add(double a , double b) ;
double subtract(double a , double b) ;
double multiply(double a , double b) ;
double divide(double a , double b) ;
double calc_service(double a , double b , double(*func_ptr)(double , double)) ;

/*
The below function is a utility function which calls other function
*/

double calc_service(const double a , const double b , double (*func_ptr)(double , double))
{
     
 return  func_ptr(a,b) ;
}

double add(double a  , double b)
{
    return a+b ;
}

double subtract(double a , double b)
{
    return a-b ;
}

double multiply(double a , double b)
{
    return a*b ;
}

double divide(double a , double b)
{
    if(a == 0 || b == 0)
     return INT_MIN ;
    return a/b ;
}

int main(int argc,char*argv[])
{
 int option;
 double a ,b , result ;
 double (*func_ptr)(double , double) ;
printf("Enter option from below:\n1.Add numbers\n2.Subtract numbers\n3.Multiply numbers\n4.Divide numbers") ;
while(1)
{
    printf(">>>") ;
    scanf("%d",&option) ;
    switch (option)
    {
    case 1:
        /* code */
        printf("Enter a,b:");
        scanf("%lf%lf",&a,&b) ;
        func_ptr = add ;
        result=calc_service(a,b,func_ptr) ;
        printf("Result: %lf" , result) ;
        break;
    case 2:
    /* code */
        printf("Enter a,b:");
        scanf("%lf%lf",&a,&b) ;
        func_ptr =subtract ;
        result=calc_service(a,b,func_ptr) ;
        printf("Result: %lf" , result) ;
        break;
    case 3:
    /* code */
        printf("Enter a,b:");
        scanf("%lf%lf",&a,&b) ;
        func_ptr = multiply;
        result=calc_service(a,b,func_ptr) ;
        printf("Result: %lf" , result) ;
        break;
    case 4:
    /* code */
        printf("Enter a,b:");
        scanf("%lf%lf",&a,&b) ;
        func_ptr =divide ;
        result=calc_service(a,b,func_ptr) ;
        printf("Result: %lf" , result) ;
        break;
    
    default:
        exit(EXIT_FAILURE) ;
    }
    printf("\n") ;
}

free(func_ptr) ;
return 0;
}



