#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 
 
 void selectionSort(int *ar,int n)
 {
     int i ,j,temp,min;

     for(i=0;i<n-1;i++)
     {
         min=i;//assumption
         for(j=i+1 ; j<n ;j++)
          {
              if(ar[j]< ar[min])
                min=j;//selection
          }
          //swapping of elements is done here
          temp =ar[min];
          ar[min] = ar[i];
          ar[i] = temp;
     }
   
 }
 
int main(int argc,char*argv[])
{
  int a[] = {13, 3, 63, 23, 83,-3};
  int n =sizeof(a)/sizeof(int);
  selectionSort (a,n) ;
  
  for(int n1 : a)
  {
      cout <<n1<<" " ;
  }

return 0;
}