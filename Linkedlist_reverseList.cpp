/*
reverse a linked list
take 3 pointers
current,prev,next
s1:store the address of the next node in the 'next'
s2:point the next node to prev node
a3:shift the prev to current node
s4:shift the current node pointer to the next node
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

void fun(Node *start)
{
    if(start == NULL)
    return;
    printf("%d ",start->data);
    fun(start->address_next_node->address_next_node);
    printf("%d",start->data);
}

void reverse_list(Node ** head)
{
    Node * current,*prev,*next;
    //initializations
    current=*head;//current is placed at the head node
    prev=next=NULL;

    while(current)//until the last node
    {
        //s1
        next=current->address_next_node;//point the next node
        //s2
        current->address_next_node=prev;//initially first
        prev=current;//move the prev to current s3
        current=next;//s4
    }
    //finally
    *head=prev;
}

int main(int argc, char const *argv[])
{
    Node* head=NULL;
    for(int i=1;i<=6;++i)
    {
        push(&head,i);
    }
    show_list(head);
    //reverse_list(&head);
   // show_list(head);
   fun(head);
    free_memory(head);
    return 0;
}
