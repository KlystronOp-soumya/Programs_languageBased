/*
club the even and the odd elements
*/
#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next;
} Node;

void append_node(Node **head, int val)
{
    Node *temp, *r;

    if (*head == NULL)
    {
        temp = new Node();
        temp->data = val;
        temp->next = NULL;
        *head = temp;
    }
    else
    {
        temp = *head;
        while (temp->next != NULL)
            temp = temp->next;

        r = new Node();
        r->data = val;
        r->next = NULL;
        temp->next = r;
    }
}

void display_list(Node *head)
{
    Node *temp;
    temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << "\n";
}

void deallocate(Node *head)
{
    while (head)
    {

        Node *temp = head;
        head = (head)->next;

        free(temp);
        /* cout<<"deallocating"<<endl; */
    }

    /* cout<<"Deallocated"; */
}

void append_odd(Node *t, Node **olh)
{
    Node *temp, *r;

    if (*olh == NULL)
    {
        *olh = new Node();
        (*olh)->data = t->data;
        (*olh)->next = NULL;
    }
    else
    {
        temp = *olh;
        while (temp->next != NULL)
            temp = temp->next;

        r = new Node();
        r->data = t->data;
        r->next = NULL;
        temp->next = r;
    }
}

Node *get_even_list(Node **head, Node **odd_list_head)
{
    Node *temp, *old;
    temp = *head;
    while (temp)
    {
        int val = temp->data;
        if ((val & 1) == 1) //odd
        {
            append_odd(temp, odd_list_head);
            old->next = temp->next;
        }
        else
        {
            old = temp;
        }

        temp = temp->next;
    }
    return *head;
}

Node *seggregate_nodes(Node *elh, Node *olh)
{
    //concatenate the odd list with even list
    //traverse
    Node *temp, *new_head;
    temp = elh;
    while (temp->next != NULL)
        temp = temp->next;

    //concat
    temp->next = olh;

    new_head = elh;

    return new_head;
}
int main(int argc, char const *argv[])
{
    Node *head, *seg_head;
    Node *odd_list_head, *even_list_head;
    odd_list_head = even_list_head = NULL;
    head = NULL;
    for (int i = 2; i <= 30; ++i)
    {
        append_node(&head, i); //appending nodes,referrence of the head pointer is passed
    }
    cout << "Displaying whole list";
    display_list(head);

    //splitting the exiting node
    even_list_head = get_even_list(&head, &odd_list_head);

    cout << "Even list\n";
    display_list(even_list_head);

    cout << "Odd list\n";
    display_list(odd_list_head);

    //seggration
    seg_head = seggregate_nodes(even_list_head, odd_list_head);

    cout << "Seg list\n";
    display_list(seg_head);

    //Deallocating all the nodes
    deallocate(head);
    deallocate(even_list_head);
    deallocate(odd_list_head);
    deallocate(seg_head);

    return 0;
}