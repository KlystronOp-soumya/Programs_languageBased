#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next;
} Node;

void append(Node **head, int val)
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
        {
            temp = temp->next;
        }
        r = new Node();
        r->data = val;
        r->next = NULL;
        temp->next = r;
    }
}

void do_merge(Node **head1, Node **head2, Node **merger)
{
    Node *temp;
    //traverse the first list
    temp = *head1;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    //last node of firs list
    temp->next = *merger;
    temp = *head2;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    //last node of firs list
    temp->next = *merger;
}

void find_mergingpoint(Node *head1, Node *head2)
{

    while (head1)
    {
        Node *temp = head2;
        while (temp)
        {
            if (temp == head1) //same address
            {
                cout << "Merging Point found at: " << temp << " with data: " << temp->data;
                return;
            }
            temp = temp->next;
        }
        head1 = head1->next;
    }
}

void split_at_merging_point(Node *head1, Node *head2)
{
    return;
}


void display(Node *head)
{
    Node *temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
}

void dealloc(Node *head)
{
    while (head)
    {
        Node *temp = head;
        delete temp;
        head = head->next;
    }
}
int main(int argc, char const *argv[])
{
    Node *head1, *head2, *merger;
    head1 = NULL;
    head2 = NULL;
    merger = NULL;

    for (int i = 1; i <= 2; ++i)
    {
        append(&head1, i);
    }
    for (int i = 3; i <= 5; ++i)
    {
        append(&head2, i);
    }
    for (int i = 6; i <= 7; ++i)
    {
        append(&merger, i);
    }
    display(head1);
    cout << endl;
    display(head2);
    cout << endl;
    display(merger);
    cout << endl;

    do_merge(&head1, &head2, &merger);

    display(head1);
    cout << endl;
    display(head2);
    cout << endl;

    find_mergingpoint(head1, head2);

    dealloc(head1);
    dealloc(head2);
    dealloc(merger);

    return 0;
}
