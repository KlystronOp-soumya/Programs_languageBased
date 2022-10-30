/*Using Double pointer*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
typedef struct CIRCULAR_LL
{
    int data;
    struct CIRCULAR_LL  *next;
} circ_node;
 
void append_circ(circ_node **front, circ_node ** rear, int data)
{
    circ_node *temp;
    //allocate
    temp = (circ_node*) malloc(sizeof(circ_node));
    if(!temp)
    {
        printf("Allocation error");
        return ;
    }
    temp->data = data;
    //if queue is empty
    if(*front == NULL)
    {
        *front = temp; //points to the current node
    }
    else
    {
        (*rear)->next=temp;
    }
    //shifts the always to the last node
    *rear= temp;
    //the back link
    (*rear)->next = *front;
}

int delete_circ(circ_node **front, circ_node **rear)
{
    circ_node *temp;
    int item;
    //check empty
    if(*front == NULL)
    {
        printf("List is empty");
    }
    else
    {
        //if first node
        if(*front == *rear)
        {
            item=(*front)->data ;
            free(*front);
            *front =NULL;
            *rear=NULL;
        }
        else
        {
            temp=*front;
            item=(*front)->data;
            *front = (*front)->next ; //shifts to next
            (*rear)->next = *front ; //new front
            free(temp);
        }
        return item;
    }
    return NULL;
}

void disp_circ(circ_node *f)
{
    circ_node *temp = f,*p=NULL;

    while(temp != p)
    {
        printf("%d",temp->data);
        temp=temp->next;
        p=f ;
    }
}
int main(int argc,char*argv[])
{
 
return 0;
}