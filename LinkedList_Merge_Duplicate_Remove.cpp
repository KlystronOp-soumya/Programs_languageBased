#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

typedef struct LINKED_LIST
{
    int data;
    struct LINKED_LIST *next;
}LL_Node;

/*
This function inserts accordingly the values in
ascending order during insertion
*/
void insert(LL_Node **head,int val)
{
    LL_Node *temp,*r;
    temp=*head ;
    r = new LL_Node;
    r->data = val;
    if(*head == NULL ||(*head)->data >val ) //then add at begining
    {
        
        *head = r ;
        (*head)->next= temp;//pointing to self for first
    }
    else
    {
      while(temp) // not null
      {
        if(temp->data < val && (temp->next==NULL || temp->next->data > val))
        {
            r->next = temp->next;
            temp->next = r;
            return;
        }
        temp=temp->next ;
      }  
    }
    r->next = NULL;
    temp->next = r;
}
int main(int argc,char*argv[])
{
 
return 0;
}