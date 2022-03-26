#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 
 
 void insertionSort(int *ar,int n)
 {
     int key,j,i;
     /*
     Starting from the index 1,since it is assumed that the 0th index element is in the sorted place
     */
     for( i = 1 ; i <n ; i++)
     {
         key=ar[i];
         j=i-1 ;
        while(ar[j]>key && j>=0)
        {
            ar[j+1]=ar[j] ;
            j-=1 ;
        }
         ar[j+1]= key;
     }
 }
 
int main(int argc,char*argv[])
{
 int ar[]={1,3,4,6,7,5,8,14,11};
 insertionSort(ar,9) ;
 for(int i = 0 ;i<9;i++)
  printf("%d ",ar[i]);

return 0;
}
