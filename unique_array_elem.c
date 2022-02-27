/*
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
 
 
int main(int argc,char*argv[])
{
 int ar[]={1,1,2,2,3,3,3,4,4,5,6,6} ;
 int n = sizeof(ar)/sizeof(int) ;
 int unq ;
 for(int i = 0 ; i<n ; i++)
 {
   /*  if(ar[i] == ar[i+1])
      i+=2;
    else
    {
        unq = ar[i+1] ;
        i++;
    } */ 

    int j;
    for(j = 0 ;j<n;j++)
    {
        if(i!=j && ar[i] == ar[j])
        {
          break;
        }
        
    }
    if(j==n)
    {
        unq=ar[i] ;
    } 

      
 }
printf("unique element: %d",unq);

return 0;
}