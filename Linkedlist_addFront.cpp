/*
Add node in front of the linked list/push function
*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node* address_next_node;
}Node;

void show_list(Node * head_node_adress)
{
    Node* temp;
    temp=head_node_adress;//address of the head node is copied
    while(temp)
    {
        //show the data
        cout<<temp->data<<" ";
        //shift the pointer to the next node
        temp=temp->address_next_node;//next node address is now stored
    }
    cout<<"\n";
}

void free_memory(Node *head)
{
    Node * temp;
    
    while(temp)
    {
        temp=head;
        head=head->address_next_node;//shift the head
        delete temp;
    }
    //cout<<"Freed";
}

Node* copy_list(Node *to_be_copiedList_head)
{
    Node* curr_list=to_be_copiedList_head;
    Node * copy_list_head,*copy_list_next;
    copy_list_head=copy_list_next=NULL;//initialized with next;
   
    //first time
    while(curr_list!=NULL)
    {
        cout<<"working";
        if(copy_list_head==NULL)
        {
            cout<<"new Node created";
            copy_list_head=new Node;
            copy_list_head->data=curr_list->data;
            copy_list_head->address_next_node=NULL;
            copy_list_next=copy_list_head;//pointing to same node
        }
        else
        {
            cout<<"tail node created";
            copy_list_next->address_next_node=new Node;//since for the first time the both od the pointers are pointing to the same node
            copy_list_next=copy_list_next->address_next_node;//shifted to newly created node
            copy_list_next->data=curr_list->data;//existing list node data
            copy_list_next->address_next_node=NULL;//next is null if not created
            
        }
        curr_list=curr_list->address_next_node;
        
    }
    cout<<copy_list_head;
  return copy_list_head;//address of the head node
}

void push(Node **head,int data)
{
    Node *temp;
     //cout<<"null node";
       temp=new Node;
       temp->data=data;
       temp->address_next_node=*head;//NULL for the first time
       *head=temp;
       //cout<<temp->data; //address is replaced

}

int main(int argc, char const *argv[])
{
    
    Node * head=NULL;
    int choice;
    Node * dup_head=NULL;
    /* do{
      cout<<"1.Push 2.show actual 3.copy 4.show copy 5.clear all"<<endl;
      cin>>choice;
      switch (choice)
      {
      case 1: int data;
              cout<<"Enter::";
              cin>>data;
              push(&head,data);
              break;
      case 2:show_list(head);
               break;
      case 3: dup_head=copy_list(head);
               break;
      case 4:show_list(dup_head);
             break;
      default:free_memory(head);
              free_memory(dup_head);
              cout<<"cleared";
          break;
      }
    }while(choice<=4); */

    for(int i=1;i<=5;++i)
    {
        push(&head,i);
    }
    show_list(head);
    //dup_head=copy_list(head);
   // show_list(dup_head);
    free_memory(head);
   // free_memory(dup_head);
    
    return 0;
}
