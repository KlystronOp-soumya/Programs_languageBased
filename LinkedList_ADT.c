#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
/*
Program to implemt the LinkedList all operations as ADT
*/ 


typedef struct llnode
{
    int data;
    struct llnode * next;
}Node;

/*method signatures*/
void append(Node *,int);
int count_nodes(Node *);
void display(Node*head);
void deallocation(Node*);

int main(int argc,char*argv[])
{
 
 Node head;//allocated with garbage value
 head.next = NULL;//initialization
 head.data=INT_MIN;//initialization
 Node *head_ptr = &head;
 
 for(int i =0 ; i<=5 ;i++)
 {
    append(head_ptr,i);
 }
 display(head_ptr);
 printf("NOW %d\n\n",head_ptr->data);
 deallocation(head_ptr);
 if(head_ptr != NULL)
 {
    printf("After deallocation head is null") ;
 }
 display(head_ptr);
return 0;
}

void append(Node * head, int data)
{
    Node*temp,*r;
    if(head!=NULL)
     printf("head node address is not null\n");
    else
     printf("head node address is null\n");

     if(head->next == NULL && (*head).data == INT_MIN) //first node
     {
       /*  temp = (Node *)malloc(sizeof(Node));
        temp->data = data;
        temp->next=NULL; */
        head->data=data ;
        head->next = temp;
     }
     else
     {
        temp=head;//assigning the address
        while(temp->next!= NULL)
        {
            printf("temp is now currently pointing to:%d\n",temp->data);
            temp=temp->next;
        }
        r=(Node *)malloc(sizeof(Node)*1);
        printf("allocation of r: %u\n",r);
        fflush(stdout);
        r->next=NULL;
        r->data=data;
        temp->next = r;
  ;
         
     }

}

void  display(Node * head)
{
    Node *temp;
    temp = head;
    while(temp)
    {
        printf("||%d|%u||->",temp->data,temp->next);
            temp=temp->next;
    }
    printf("NULL");
}

/*deallocation wont work since the allocation has not been done using Malloc*/
void deallocation(Node *head)
{

    while(head)
    {   
        Node * temp;
        temp=head;
        head=head->next;
        printf("||%d|%u||->",temp->data,temp->next);
        printf("deallocated Node\n");
        free(temp); 
        
    }
    free(head);

}