//Circular linked list implementation
//apply do while loop
#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    struct node *next_node_add;
};
typedef struct node circ_node;

circ_node* append(circ_node* head,int val)
{
    //cout<<"called1";
    circ_node *temp,*r;
    if(head == NULL)
    {
        temp=new circ_node();
        if(!temp)
        {
            cout<<"Memory Error";
            exit(1);
        }
        //cout<<"called2";
        temp->data=val;
        temp->next_node_add=temp;//not null since this is a circulcar linked list 
        head=temp;
    }
    else{
        //cout<<"called5";
        temp=head;
        do{
            //cout<<"called3";
            temp=temp->next_node_add;
        }while(temp->next_node_add!=head);
         //cout<<"called4";

        r=new circ_node();
        r->data=val;
        r->next_node_add=r;
        temp->next_node_add=r;
        r->next_node_add=head;

    }
 return head;

}

circ_node *addbeg(circ_node*head,int val)
{
    circ_node *curr=head;
    circ_node *temp;
    if(head == NULL)
    {
      temp=new circ_node();
      temp->data=val;
      temp->next_node_add=temp;
      head=temp;
    }
    else
    {
        //traverse
        while(curr->next_node_add!=head)
         curr=curr->next_node_add;
        
        temp=new circ_node();
        temp->data=val;
        temp->next_node_add=head;
        head=temp;
        curr->next_node_add=temp;
    }  
    
    return head;
}

void addEnd(circ_node **head,int val)
{

}

void addat(circ_node **head,int val,int pos)
{
    circ_node *temp;
    circ_node *curr;

    curr=*head;
    if(*head == NULL)
    {
        cout<<"Create first";
        exit(1);
     }

    for(int i=0;i<pos;++i)
    {
        curr=curr->next_node_add;
        if (curr->next_node_add == *head)
        {
            addEnd(head,val);
            return;
        }
    }
    temp=new circ_node();
    temp->data=val;
    temp->next_node_add=temp;//intermediate step
    temp->next_node_add=curr->next_node_add;
    curr->next_node_add=temp;

}

void deleteEndNode(circ_node **head)
{

}

void deleteAny(circ_node**head)
{

}
void deallocate(circ_node *head)
{
    circ_node *temp=head;
    do{
        //cout<<"Deallocated"<<endl;
        circ_node *temp2=temp;
        temp=temp->next_node_add;
        delete temp2;
    }while(temp!=head);

    delete temp;
    delete head;
    
}

void display(circ_node *head)
{
    circ_node *temp=head;
    do{
       cout<<temp->data<<" ";
       temp=temp->next_node_add;
    }while(temp!=head);
}

int main(int argc, char const *argv[])
{
    /* code */
    circ_node *head = NULL;
    for(int i=0;i<=6;++i)
    {
        head = append(head,i);
    }
    display(head);
    int val,pos;
    cout<<"Begining: ";
    cin>>val;
    
    head=addbeg(head,val);
    display(head);
    cin>>val;
    cin>>pos;
    addat(&head,val,pos);
    display(head);
    deallocate(head);
    

    return 0;
}
