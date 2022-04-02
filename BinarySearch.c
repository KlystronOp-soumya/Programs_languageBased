#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 void sort_array(int a[],int n)
 {
     for (int step = 0; step < n - 1; ++step)
    {
        for (int i = 0; i < n - step - 1; ++i)
        { 
            if (a[i] > a[i + 1])
            {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            } 
                //swap(&a[i], &a[i + 1]);               
        }
    }
 }
 
 void binary_search(int ar[],int n ,int elem)
 {
     int mid,low,high ;
     low = 0; //starting index
     high= n-1;

     

     while(low <= high)
     {
         mid=(low+high)/2 ;// low+(high-low)/2

         if(ar[mid] == elem)
         {
             printf("Element found at the index: %d",mid);
             return;
         }
         //else
         if(elem > ar[mid])
         {
             //search in the right sub array
             low=mid+1 ;
         }
         if(elem < ar[mid])
         {
             //search in the left subarray
             high=mid -1 ;
         }
     }
     printf("Element not present in the array") ;
   }
 
int main(int argc,char*argv[])
{
 
 int ar[MAX_ELEM];

 for(int i =0 ;i<5;i++)
 {
     scanf("%d",&ar[i]);
 }
 //step 1
 sort_array(ar,5);
 for(int i =0;i<5;i++)
 {
     printf("%d ",ar[i]);
 }
 printf("\n");
 //step 2
 int search=12;
 binary_search(ar,5,search);

return 0;
}