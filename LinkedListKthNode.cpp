/*
Program to find the Kth node in a LinkedList
complexity:O(n),O(1)
*/
#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next;
} Node;

/*function prototypes*/
int count_nodes(struct node *); //couting the number of nodes
/* void traverse(struct node *); */
void append_node(struct node **, int);         //append new nodes
struct node *get_kth_node(int, struct node *); //get the address of the kth node
void display_list(struct node *);              //display node
void deallocate(struct node *);                //deallocating manually

int main(int argc, char const *argv[])
{
    Node *head;
    head = NULL;
    for (int i = 11; i <= 15; ++i)
    {
        append_node(&head, i);
    }
    display_list(head);
    count_nodes(head);
    int k;
    cout << "Enter the Kth node: ";
    cin >> k;
    Node *kth_node_address = get_kth_node(k, head);

    cout << "kth node data: " << kth_node_address->data;
    deallocate(head);

    return 0;
}

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

Node *get_kth_node(int k, Node *head)
{
    int M = count_nodes(head);
    Node *temp = head;

    //corners
    if (k > M)
    {
        cout << "List has smaller length";
        return NULL;
    }
    //traverse
    for (int i = 0; i < M - k + 1; ++i)
    {
        temp = temp->next;
    }
    return temp;
}

int count_nodes(Node *head)
{
    Node *temp = head;
    int c = 0;
    while (temp)
    {
        c++;
        temp = temp->next;
    }
    cout << "The List has " << c << " number of Nodes\n";
    return c;
}