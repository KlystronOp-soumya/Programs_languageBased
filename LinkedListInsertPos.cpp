//Program to insert at a given position in a linked list
#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next_node_address;
} list_node;

//append node
void append(list_node **head_node_address, int val)
{
    list_node *temp, *r;
    if (*head_node_address == NULL)
    {
        temp = new list_node(); //allocate memory and store the address into the temp
        temp->data = val;
        temp->next_node_address = NULL;
        *head_node_address = temp; //passsed the newly created node address
    }
    else
    {
        //traverse for the last node
        temp = *head_node_address; //address is stored in the variable/pointer
        while (temp->next_node_address != NULL)
            temp = temp->next_node_address; //moving the pointer to the next node

        r = new list_node();
        r->data = val;
        r->next_node_address = NULL;
        temp->next_node_address = r;
    }
}

//count node
int count_nodes(list_node *head_node_add)
{
    register int count = 0;
    list_node *temp = head_node_add;
    while (temp)
    {
        count++;
        temp = temp->next_node_address;
    }
    return count;
}

//insert at a position
list_node *insert_at(list_node *head_node_address, int pos, int val)
{
    list_node *temp, *r;
    temp = head_node_address;
    //get the total number of nodes
    int total_nodes = count_nodes(head_node_address);
    cout << "Total number of nodes::" << total_nodes;
    if (pos > total_nodes)
    {
        cout << "List length is shorter!!";
        exit(0);
    }
    for (int i = 0; i < pos; ++i)
    {
        temp = temp->next_node_address;
    }
    r = new list_node();
    r->data = val;
    r->next_node_address = temp->next_node_address; //new node is now pointing to the next node
    temp->next_node_address = r;                    //old node is now pointing to the new node
    return head_node_address;
}

//display
void display(list_node *head_node)
{
    list_node *temp;
    temp = head_node;
    while (temp)
    {
        cout << temp->data << "-->";
        temp = temp->next_node_address;
    }
    cout << "X";
}

//deallocation of the memory
void deallocate(list_node *head)
{
    while (head != NULL)
    {
        list_node *temp = new list_node();
        temp = head;                    //store the current node address
        head = head->next_node_address; //shift the current node to pointer to the next node pointer
        delete temp;                    //free the memory
    }
}

int main(int argc, char const *argv[])
{
    list_node *head = NULL; //initialization

    //insert data
    for (int i = 11; i <= 15; ++i)
    {
        append(&head, i);
    }
    //display the list
    display(head);

    int pos, val;
    cout << "Enter pos and val to insert";
    cin >> pos >> val;
    head = insert_at(head, pos, val);
    display(head);
    //deallocate
    deallocate(head);
    return 0;
}
