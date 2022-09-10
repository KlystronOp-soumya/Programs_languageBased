/*
To-Do
1.delete
2.count
3.add in front
4.reverse
5.sort
6.merge_sort
*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    /* data */
    int data;
    struct node* next_node_add;
}Node;

/*
Traversing the list using recursion
*/
 Node *traverse_list(Node *head)
{
    Node *temp=head;//assign
    if(temp->next_node_add==NULL)
     return temp; //address of the last node is returned
    
    return traverse_list(temp->next_node_add);
   /*  while(temp->next_node_add != NULL)
    {
        temp=temp->next_node_add;
    }
    return temp;
 */
} 

void  append(Node**head_node,int data)
{
    Node* temp,*r;
   //check for the empty list
   if(head_node==NULL)
   {
       //create a node and store the address
       temp= (Node*) malloc(sizeof(Node)*1) ;//new node
       temp->data=data;
       temp->next_node_add=NULL;
       *head_node=temp;//the address is stored

   }
   else
   { temp=traverse_list(*head_node);
     /*   temp=*head_node;
       while(temp->next_node_add!=NULL)
        temp=temp->next_node_add */;

       //create a node
       r= new Node ;
       r->data=data;
       r->next_node_add=NULL;
       temp->next_node_add=r;

   }
   //return *head_node;
}

void  display(Node* head)
{
    //ITERATIVE CODE
   /*  Node*temp=head;
    while(temp)
    {
        cout<<temp->data<<" ";
        temp=temp->next_node_add;
    } */

    //using recursion
    if(!head)
      return;
    cout<<head->data<<" ";
     return display(head->next_node_add);
   
}

void deallocate(Node* head)
{
    Node* temp;
    while(head)
    {
        temp=head;
        head=head->next_node_add;
        delete temp;
    }
}
void append_lists(Node** head1,Node* head2)
{
    Node*temp1;
    //put check
    if(*head1 && head2) //non empty
    {
        temp1=traverse_list(*head1); //last node address
        /*
        Last node address is found and storing the address of the second list in the last node of  the first 
        node*/
        temp1->next_node_add=head2;

    }
    
}

int main(int argc, char const *argv[])
{
    Node* head1,*head2;
    head1=head2=NULL;
    

   //insertng in the first list
   for(int i=0;i<=5;++i)
   {
      append(&head1,i);
   }
 for(int i=6;i<=10;++i)
   {
       append(&head2,i);
   } 
  
  cout<<"list1::"<<endl;
  display(head1);
   cout<<"list2::"<<endl;
  display(head2);
  
  append_lists(&head1,head2);

  cout<<"appended list::"<<"\n";
  display(head1);

  deallocate(head1);
   deallocate(head2); 




    //insertinf in the 
    return 0;
}


