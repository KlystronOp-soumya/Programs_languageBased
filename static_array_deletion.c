/*
Program to delete an element in an array at a desired location
*/
#include<stdio.h>
#include<stdlib.h>
#define MAX 50

//function prototype for the insertion
void delete(int ar[],int n,int k);
void display(int ar[],int n)
{
    for(int i=0;i<n;i++)
     printf("%d ",ar[i]);
}
int main(int argc, char const *argv[])
{
    int ar[MAX],n,k;
    printf("enter number of elements(maximum 50)>>");
    scanf("%d",&n);

    for(int i=0;i<n;i++)
     scanf("%d",&ar[i]);

printf("array before deletion");
 display(ar,n);

 printf("enter the position>>");
 scanf("%d",&k);

 //check
 if(k>n)
 {
     printf("Index outof bound");
     exit(0);
 }
 else
 {
     delete(ar,n,k);
 }
 printf("array after insertion");
    return 0;
}
void delete(int ar[],int n,int k)
{
    int item=ar[k];

    for(int j=k;j<=n-1;j++)
     ar[j]=ar[j+1];

    n--;
    display(ar,n);
}