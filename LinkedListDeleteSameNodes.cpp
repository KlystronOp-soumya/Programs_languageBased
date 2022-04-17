/*
program to delete the same Nodes in a sorted next_Node_addressed List
*/
#include <bits/stdc++.h>
using namespace std;

typedef struct Node
{
    int data;
    struct Node *next_Node_address;
} Node;

void append(Node **head, int val)
{
    Node *temp, *r;
    if (*head == NULL)
    {
        temp = new Node();
        temp->data = val;
        temp->next_Node_address = NULL;
        *head = temp;
    }
    else
    {
        temp = *head;
        while (temp->next_Node_address)
        {
            temp = temp->next_Node_address;
        }
        r = new Node();
        r->data = val;
        r->next_Node_address = NULL;
        temp->next_Node_address = r;
    }
}

void display(Node *head)
{
    while (head)
    {
        cout << head->data << " ";
        head = head->next_Node_address; //traverse
    }
    cout << "\n";
}

int count_Nodes(Node *head)
{
    register int c = 0;
    while (head)
    {
        c++;
        head = head->next_Node_address;
    }
    return c;
}
/* void sort(Node **head)
{
    Node *p, *q;
    p = q = *head;
    int n = count_Nodes(*head);
    for (int i = 0; i < n - 1; ++i)
    {
        q = q->next_Node_address;
        for (j = i + 1; j < n; ++j)
        {
            if (p->data > q->data)
            {
                int temp = p->data;
                p->data = q->data;
                q->data = temp;
            }
        }
    }
} */

void deallocate(Node *head)
{

    while (head)
    {
        Node *temp = head;
        head = head->next_Node_address;
        free(temp);
    }
}

//maintaining two pointers
void delete_dups(Node **head)
{
    Node *curr, *next;
    curr = *head;
    next = curr->next_Node_address;
    while (curr)
    {
        if (next == NULL)
        {
            break;
        }
        if (curr->data == next->data)
        {
            curr->next_Node_address = next->next_Node_address;
            Node *temp = next;
            next = next->next_Node_address;
            free(temp);
        }
        else
        {
            next = next->next_Node_address;
            curr = curr->next_Node_address;
        }
    }
    free(next);
    free(curr);
}

int main(int argc, char const *argv[])
{
    Node *head = NULL;
    for (int i = 0; i < 8; ++i)
    {
        int x;
        cin >> x;
        append(&head, x);
    }
    cout << "Actual List:\n";
    display(head);
    SelectionSort(&head);
    cout << "List after deletion:\n";
    delete_dups(&head);
    display(head);
    deallocate(head);
    return 0;
}
