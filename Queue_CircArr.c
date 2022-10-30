#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 10
 
void enqueue(int *ar, int item,int *pfront, int *prear)
{
    if((*prear == MAX_ELEM-1 && *pfront == 0 ) || (*prear+1 == *pfront))//circular
    {
        printf("Queue overflow") ;
        return ;
    }
    if(*prear == MAX_ELEM -1 )//if already at end, move it to 0th index
     *prear = 0;
    else
     (*prear)++ ;//otherwise increase

     ar[*prear] = item;//store

     if(*pfront == -1)//at initial pos
     {
        *pfront=0 ;
     }
}

int dequeue(int *arr,int*pfront ,int *prear)
{
    int deleted_item;

    if(*pfront == -1)
    {
        print("Queue is empty\n");
        return NULL ;
    }
    deleted_item = arr[*pfront];
    arr[*pfront] = 0;//marking as deleted item

    if(*pfront == *prear)//if single element
    {
        *pfront=*prear=-1 ;
    }
    else
    {
        if(*pfront == MAX_ELEM-1) //if single element/front is at last move to zero as circular
            *pfront = 0;
        else
            (*pfront) ++ ;
    }
    return deleted_item ;
}

void display(int * ar)
{
    for(int i =0;i<MAX_ELEM ;i++)
    {
        printf("%d\t",ar[i]) ;
    }
    printf("\n");
}
int main(int argc,char*argv[])
{
 
return 0;
}