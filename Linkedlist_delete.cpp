#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node* next;
}Node;

//append data
Node* push(Node** head,int data)
{
    Node *temp,*r;
  if(*head==NULL)
 {
     temp=new Node;
     temp->data=data;
     temp->next=NULL;
     *head=temp;
 }
 else
 {
     temp=*head;
     //traverse
     while(temp->next!=NULL)
     temp=temp->next;

     r=new Node;
     r->data=data;
     r->next=NULL;
     temp->next=r;
 }
 return *head;
}

//count 
int count_nodes(Node* head)
{
  Node *temp;
  temp=head;
  int c=0;
  while(temp)
  {
      c++;
      temp=temp->next;
  }
  return c;
}

//delete data
void delete_node(Node**head,int value)
{
   Node *temp,*old;
   temp=*head;
   while(temp!=NULL)
   {
       //check for the value
       if(temp->data==value)
       {
           //if first node
           if(temp==*head)
             *head=(*head)->next;
           else
             {
                 old->next=temp->next;
                 
             }
             delete(temp);
             return;
       }
       else
       {
           old=temp;
           temp=temp->next;
       }
       
   }
}
void show(Node* head)
{
   Node *temp;
   temp=head;
   while(temp)
   {
       cout<<temp->data<<" ";
       temp=temp->next;
   }
} 

void deallocate(Node*head)
{
    Node* temp;
    while(head)
    {
        temp=head;
        //shift to next node
        head=head->next;
        delete(temp);//deallocate
    }
}
int main(int argc, char const *argv[])
{
    int choice,data;
    Node* head;
    //initialization
    head=NULL;
    cout<<"1.append 2.count 3.show 4.delete 5.exit";
    do
    {
        cout<<"choice:";
        cin>>choice;
        switch(choice)
        {
            case 1:{ cout<<"data:";
                    cin>>data;
                    head=push(&head,data);
                    break;

            } 
                   

            case 2:{int c=count_nodes(head);
                    cout<<"Number of nodes:"<<c<<endl;
                    break;

            } 
            case 3: {
                show(head);
                    break;
            }
            case 4:
            {
                cout<<"delete:";
                   cin>>data;
                   delete_node(&head,data);
                   break;
            }
            default: exit(0);

        }
    }while(choice<=4);
    deallocate(head);
    return 0;
}
