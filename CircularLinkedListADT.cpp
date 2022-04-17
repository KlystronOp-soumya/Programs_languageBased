//working
#include <bits/stdc++.h>
using namespace std;

typedef struct CircularLinkedListADT
{
    /* data */
    int data;
    struct CircularLinkedListADT *next_node_address;
} circ_node;

void append(circ_node **head, int val)
{
    circ_node *temp, *r;
    if (*head == NULL)
    {
        temp = new circ_node();
        temp->data = val;
        *head = temp;
        temp->next_node_address = *head;
    }
    else
    {
        temp = *head;
        while (temp->next_node_address != *head)
            temp = temp->next_node_address;

        r = new circ_node();
        r->data = val;
        temp->next_node_address = r;
        r->next_node_address = *head;
    }
}

void addFront()
{
}

void addAny()
{
}

void show(circ_node *head)
{
    circ_node *temp;
    temp = head;
    while (temp->next_node_address != head)
    {
        cout << temp->data << " ";
        temp = temp->next_node_address;
    }
    cout << temp->data;
}

void deleteNode()
{
}

void sort()
{
}
void deallocate(circ_node *head)
{
    while (head->next_node_address != head)
    {
        circ_node *temp = head;
        head = head->next_node_address;
        delete temp;
    }
    delete head;
}

int main(int argc, char const *argv[])
{
    /* code */
    circ_node *head;
    head = NULL;
    for (int i = 0; i <= 10; ++i)
        append(&head, i);

    show(head);
    deallocate(head);
    return 0;
}
