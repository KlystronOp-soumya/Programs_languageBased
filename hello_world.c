#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>


void main()
{
    printf("Hello World");
    for(int m=0;m<=4;++m)
    {
        if (m == m++ + --m)
        {
            /* code */
            printf("%d",m);
        }
        
    }
    

   //return;
}



