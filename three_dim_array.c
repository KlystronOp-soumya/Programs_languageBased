#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
    int i ,j,k;
 int ar[2][3][3]={
     {
         {1,2,3},
         {4,5,6},
         {7,8,9}
     },
     {
         {10,11,12},
         {13,14,15},
         {16,17,18}
     },
     
   
 };
    for(i =0; i<2;i++)
    {
        for(j = 0 ;j<3;j++)
        {
            for(k = 0;k<3;k++)
            {
                printf("%d ", ar[i][j][k]) ;
            }
            if(k==3)
             printf("\n");
        }
        printf("\n") ;
    }
return 0;
}