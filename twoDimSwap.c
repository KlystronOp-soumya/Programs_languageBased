#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 void display(int (*ar)[3])
 {
     for(int i =0;i<2;i++)
     {
        for(int j = 0;j<3;j++)
        {

            printf("%d and %u \n",ar[i][j],&ar[i][j]) ;
        }
     }
 }
 
 void swap(int (**ar1)[3],int (**ar2)[3])
 {
     int (**t)[3] ;
     printf("1:%u \n",*ar1);
     printf("2:%u \n",*ar2);
     t= *ar1;
     *ar1=*ar2;
     *ar2=t ;
     printf("1:%u \n",*ar1);
     printf("2:%u \n",*ar2);
 }
int main(int argc,char*argv[])
{
 int ar[][3] ={
     {1,2,3},
     {10,11,12}
 } ;

    display((int(*)[3])ar[0]) ; //base address of the whole array
    swap((int(**)[3])&ar[0],(int(**)[3])&ar[1]) ;
    printf("\n");
    display((int(*)[3])ar[0]) ;
return 0;
}