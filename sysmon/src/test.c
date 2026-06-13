#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 


int main(int argc, char* argv[])
{
    long a, b;
    printf("Enter the values a,b: ");
    scanf("%d%d", &a, &b);
    long long sum = a + b;

    printf("sum = %ul", sum);

    return 0;
}