#include<bits/stdc++.h>

using namespace std;

typedef struct node{
    int data;
    struct node *next_node_address;
} Node;

/* void traverse_end(Node * temp,Node *head)
{
    temp=head;
    while(temp)
    temp=temp->next_node_address;
} */
Node * create_list(Node * head,int n)
{
    Node * temp,*r;
    cout<<"Called\n";
    if(head==NULL)
    {
       cout<<"head created"<<endl;
       head=new Node();
       head->data=n;
       head->next_node_address=NULL;
    }
    else
    {
        temp=head;
        //traverse to the end node
        /* traverse_end(temp,head); */
        while(temp->next_node_address!=NULL)
        temp=temp->next_node_address;

        cout<<"node created"<<endl;
        r =new Node();
        r->data=n;
        r->next_node_address=NULL;
        temp->next_node_address=r;
    }
    return head;
}

void display_list(Node *head)
{
    cout<<"Display";
    Node *temp=NULL;
    //temp=new Node();
    temp=head;
    while(temp)
    {
        cout<<temp->data<<" "<<endl;
        temp=temp->next_node_address;
    }
}
void deallocate(Node * head)
{
    
    
    while(head)
    {
        
        Node *temp=head;
        head=(head)->next_node_address;
        
        free(temp);
        /* cout<<"deallocating"<<endl; */
    }
    
    /* cout<<"Deallocated"; */
}

void reverse_list(Node** head)
{
    Node* curr_node,*prev_node,*next_node;
    //init
    prev_node=next_node=NULL;
    curr_node=*head;
    while (curr_node)
    {
        /* code */
        //store the address of the next node
        next_node=curr_node->next_node_address; //next node address is stored
        //reverse the curr to next node pointer
        curr_node->next_node_address=prev_node;
        //shift the prev node to current node
        prev_node=curr_node;
        //shit the curr node to next node
        curr_node=next_node;

    }
    //ultimately store the last node address as the head node
    *head=curr_node;
    
}

int main(int argc, char const *argv[])
{
    Node *head=NULL;
    int n;
    cin>>n;
    for(int i=0;i<n;++i)
    {
        int temp;
        cin>>temp;
       head = create_list(head,temp);
    }
    //display
    display_list(head);
    deallocate(head);
    return 0;
}
