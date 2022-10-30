//Implementation of the doubly linked list
/*
  int data
  prev_node adress pointer
  next_node address pointer   
*/
#include <bits/stdc++.h>
using namespace std;

//create the doubly linked list node structure
typedef struct doubly_ll_node
{
    int data;
    struct doubly_ll_node *prev_node_address;
    struct doubly_ll_node *next_node_address;
}Node;

void append(Node **head,int data)
{
  Node *r, *temp=*head;
  //if empty list
  if(*head == NULL)
  {
    temp= new Node;
    temp->data = data;
    temp->prev_node_address = NULL;
    temp->next_node_address = NULL;
    *head = temp;
  }
  else
  {
    while (temp->next_node_address != NULL)
    {
      temp=temp->next_node_address ;
    }
    r = new Node;
    r->data = data;
    r->next_node_address = NULL;
    r->prev_node_address = temp;
    temp->next_node_address = r;
   
  }
}

void add_beg(Node **head, int val)
{
  Node *temp;
  temp = new Node;
  if(*head == NULL)
  {
    append(head,val);
  }
  if(!temp)
  {
    printf("Allocation error");
    return;
  }
  temp->data = val;
  temp->prev_node_address = NULL;//first node
  temp->next_node_address= *head;//points to previous Head
  (*head)->prev_node_address = temp;
  *head = temp; //setting the new Head
}

void add_any(Node **head,int val, int pos)
{
  Node *temp,*r ;
  if(*head == NULL)
  {
    fprintf(stderr,"%s","Head node is NULL");
    add_beg(head,val);
  }
  temp = *head;
  for(int  i = 0;i<pos ;i++)
  {
    if(temp)
    temp= temp->next_node_address;
    else 
    {
      fprintf(stderr,"%s","position not found");
      return;//position not found
    }
  }
  temp = temp->prev_node_address ;
  r = new Node;
  r->data = val;
 r->prev_node_address = temp;
 r->next_node_address = temp->next_node_address;
 temp->next_node_address->prev_node_address=r;
 temp->next_node_address=r ;
}
void delete_node(Node **head,int val)
{
  Node *temp = *head;
  while(temp)
  {
    //delete by data
    if(temp->data == val)
    {
      //if first Node
      if(temp == *head)
      {
        *head = (*head)->next_node_address;
        (*head)->prev_node_address = NULL ;
        free(temp) ;
      }
      else
      {
        //end node
        if(temp->next_node_address ==NULL)
        {
          temp->prev_node_address->next_node_address = NULL;
        }
        else //any intermediate node
        {
          //temp's prev node points to the next to temp node
          temp->prev_node_address->next_node_address = temp->next_node_address;
          //temp's next node points to the prev node of the temp
          temp->next_node_address->prev_node_address = temp->prev_node_address ;
        }
        free(temp) ;
      }
      return;
    }
    temp=temp->next_node_address ;
  }
}
int main(int argc, char const *argv[])
{

    return 0;
}

