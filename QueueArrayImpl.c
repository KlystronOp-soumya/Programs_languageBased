#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 5
 
void enqueue(int arr[],int data,int *front, int *rear)
{
    if(*rear == MAX_ELEM-1) //if rear is at the last index then
    {
        printf("Queue is full");
        exit(1) ;
    }

    (*rear) ++ ; //shifting the rear
    arr[*rear] = data;

    if(front == -1)
        *front = 0 ;
}
int main(int argc,char*argv[])
{
  int arr[MAX_ELEM] ;
  int front = -1,rear=-1 ;

  for(int i =1 ;i<=5 ;i++)
  {
    enequeue(arr,i,&front,&rear);
  }
return 0;
}