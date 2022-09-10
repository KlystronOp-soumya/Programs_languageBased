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
        //temp->next_node_address=NULL ;
        *head = temp;
        temp->next_node_address = *head;
    }
    else
    {
        temp = *head;
        //traverasal
        while (temp->next_node_address != *head)
            temp = temp->next_node_address;

        r = new circ_node();
        r->data = val;
        temp->next_node_address = r;
        r->next_node_address = *head;//pointing to the head node

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

void deleteNodeLast(circ_node **head)
{
    circ_node *temp = *head,*current = *head;

    if(*head== NULL)
    {
        printf("List empty!!");
        return;
    }
    while(current->next_node_address != *head)
    {
        temp =current ;
        current = current->next_node_address ; //moving to next node
    }
    /*
    current->next point/holds the address of head node
    temp is moved to the node before the last node
    changing the next node address for temp to head(current->next)
    */
    temp->next_node_address = current->next_node_address ;
    free(current);
    return;
}

void deleteFirstNode(circ_node **head)
{
    circ_node *temp = *head,*current= *head;
    if(*head== NULL)
    {
        printf("List empty!!");
        return;
    }

    //traverse
    while(current->next_node_address!= *head)
      current = current->next_node_address;
    
    current->next_node_address = (*head)->next_node_address ;//shifting the back link to the node next to head
    *head =(*head)->next_node_address ;//shifting the head to the next node this is new head
    free(temp);//temp points to the old head
    return ;
    
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
