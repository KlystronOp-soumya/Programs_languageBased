/*
Implementation of the Floyd's algorithm to detect the loop in a linked list
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
void display_list(Node *head)
{
    Node *temp;
    temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

void create_cycle(Node **head)
{
    Node *curr, *old;
    curr = old = *head;
    int pos = 5;

    for (int i = 0; i < pos - 1; ++i)
    {
        old = old->next; //going to 5th node
    }

    //traverse to last node
    while (curr->next != NULL)
        curr = curr->next;

    //changing the last node next pointer from null to 5th node
    curr->next = old;
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

bool do_contain_cycle(Node **head)
{
    Node *tortoise, *hare;
    tortoise = hare = *head;
    //shift the hare
    hare = hare->next->next; //starts with 2hops
    bool decesion = false;

    while (1) //an infinite loop
    {
        if (tortoise == hare) //if they to the same node
        {
            decesion = true;
            cout << "found at:" << tortoise->data;
            break;
        }
        //corner
        if (hare->next->next == NULL) //if singly list
        {
            break;
        }
        tortoise = tortoise->next; //single hop
        hare = hare->next->next;   //2hops
    }
    return decesion;
}
int main(int argc, char const *argv[])
{
    Node *head;
    head = NULL;
    for (int i = 11; i <= 20; ++i)
    {
        append_node(&head, i);
    }
    int nof_nodes = count_nodes(head);
    display_list(head);

    //create_cycle(&head);
    //display_list(head);
    cout << "the list conatins cycle: " << do_contain_cycle(&head);
    deallocate(head);

    return 0;
}
