//Implementation of Deque or double ended queue using Array
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX 5

void add_at_beg(int * ,int ,int * ,int *) ;
void add_at_end(int *,int, int *,int *) ;
int del_at_beg(int *,int *,int *) ;
int del_at_end (int *,int *, int *) ;
void display (int *) ;
int count (int *) ;

 
 
int main(int argc,char*argv[])
{
 
return 0;
}

void add_at_beg(int *arr,int item,int * front,int *rear) 
{
    int i,k,c ;

    if(*front == 0 && *rear == MAX -1 ) //then the array is full
    {
        printf("Deque is full") ;
        return ;
    }

    if(*front == -1 )
    {
        *front = *rear = 0 ; //shifting the to valid index
        arr[*front] = item ; //to add the data
        return ;
    }

    if(*rear != MAX-1)
    {
        c =count(arr) ;
        k=*rear+1 ; //increasing the rear
        for(int i = 1 ; i<=c ;i++)
        {
            arr[k] = arr[k-1] ; //shifting the elements 
            k-- ; // decreasing the  k
        }
        arr[k] = item ; //assigning new item
        *front = k ;
        *(rear)++ ;
    }
}

void add_at_end(int * arr, int item,int *front, int * rear)
{
    int i , k;
    if(*front == 0 && *rear == MAX -1 ) //then the array is full
    {
        printf("Deque is full") ;
        return ;
    }
    if(*front == -1 )
    {
        *front = *rear = 0 ; //shifting the to valid index but this time inserting from back
        arr[*rear] = item ; //to add the data
        return ;
    }
     if(*rear != MAX-1)
    {
        k = *front - 1 ;
       
        for(int i = *front - 1 ; i<=*rear ;i++)
        {
            k = i ;
           if(k == MAX-1)
            arr[k]=0;
           else
            arr[k]= arr[i+1] ;
        }
       *rear -- ;
       *front ++ ;
    }
    *rear ++ ;
    arr[*rear] = item ;
}

int del_at_beg (int *arr, int *front, int * rear)
{
    int item ;
    if(*front == -1)
    {
        printf("Queue is empty") ;
        return 0 ;
    }

    item= arr[*front] ;
    arr[*front] =(-1)* INT_MIN ;

    if(*front == *rear)
     *front = *rear = -1 ;
    else
     *front ++ ;
     return item ;
}

int del_at_end(int * arr, int * front, int *rear)
{
    int item ;
    if (*front == -1 )
    {
        printf("Queue is empty") ;
        return ;

    }

    item = arr[*rear] ;
    arr[*rear] = 0 ;
    *rear --; 
    if(*rear == -1)
     *front = -1 ;

     return item ;
}

int count(int arr[])
{
    register int c=0;
    for(int i =0;i<MAX ;i++)
    {
        if(arr[i]!= -INT_MIN)
        {
               c++; 
        }
    }
    return c ;
}
