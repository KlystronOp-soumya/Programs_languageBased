/*
Program to insert an element in an array at a desired location
*/
#include<stdio.h>
#include<stdlib.h>
#define MAX 50

//function prototype for the insertion
void insert(int ar[],int n,int k,int item);
void display(int ar[],int n)
{
    for(int i=0;i<n;i++)
     printf("%d ",ar[i]);
}
int main(int argc, char const *argv[])
{
    int ar[MAX],n,k,item;
    printf("enter number of elements(maximum 50)>>");
    scanf("%d",&n);

    for(int i=0;i<n;i++)
     scanf("%d",&ar[i]);

printf("array before insertion");
 display(ar,n);
 printf("enter value to be inserted>>");
 scanf("%d",&item);
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
     insert(ar,n,k,item);
 }
 printf("array after insertion");
    return 0;
}
void insert(int ar[],int n,int k,int item)
{
    int j=n;//5
    while(j>=k)//5>=2
    {
        ar[j+1]=ar[j];//ar[6]=ar[5],ar[5]=ar[4],4=3,3=2
        j--;
    }
    ar[k]=item;//ar[2]
    n++;

    display(ar,n);
}