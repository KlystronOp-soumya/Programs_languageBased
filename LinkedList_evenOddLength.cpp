#include <bits/stdc++.h>

using namespace std;

typedef struct node
{
    int data;
    struct node *next_node_address;
} Node;

Node *create_list(Node *head, int n)
{
    Node *temp, *r;
    //cout << "Called\n";
    if (head == NULL)
    {
        //cout << "head created" << endl;
        head = new Node();
        head->data = n;
        head->next_node_address = NULL;
    }
    else
    {
        temp = head;

        while (temp->next_node_address != NULL)
            temp = temp->next_node_address;

        cout << "node created" << endl;
        r = new Node();
        r->data = n;
        r->next_node_address = NULL;
        temp->next_node_address = r;
    }
    return head;
}

void display_list(Node *head)
{
    cout << "Display";
    Node *temp = NULL;
    //temp=new Node();
    temp = head;
    while (temp)
    {
        cout << temp->data << " " << endl;
        temp = temp->next_node_address;
    }
}

int get_length(Node *head)
{
    Node *temp = head;
    register int count = 0;
    while (temp)
    {
        count++;
        temp = temp->next_node_address;
    }
    return count;
}

bool get_even_odd_length(Node *head)
{
    while (head && head->next_node_address)                //checking NULL
        head = head->next_node_address->next_node_address; //giving 2 hops

    if (head)
        return 0;

    return 1;
}

bool get_even_odd_len_rec(Node *head)
{
    if (head == NULL)
        return 1;
    if (head->next_node_address == NULL)
        return 0;

    get_even_odd_len_rec(head->next_node_address->next_node_address);
}

void deallocate(Node *head)
{

    while (head)
    {

        Node *temp = head;
        head = (head)->next_node_address;

        free(temp);
    }
}

void reverse_list(Node **head)
{
    Node *curr_node, *prev_node, *next_node;
    //init
    prev_node = next_node = NULL;
    curr_node = *head;
    while (curr_node)
    {
        /* code */
        //store the address of the next node
        next_node = curr_node->next_node_address; //next node address is stored
        //reverse the curr to next node pointer
        curr_node->next_node_address = prev_node;
        //shift the prev node to current node
        prev_node = curr_node;
        //shit the curr node to next node
        curr_node = next_node;
    }
    //ultimately store the last node address as the head node
    *head = curr_node;
}

int main(int argc, char const *argv[])
{
    Node *head = NULL;
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i)
    {

        head = create_list(head, i);
    }
    //display
    display_list(head);
    cout << "Length is: " << get_length(head);
    cout << "Length type is: " << ((get_even_odd_length(head)) ? "Even" : "Odd") << endl;
    cout << "Length type is: " << ((get_even_odd_len_rec(head)) ? "Even" : "Odd") << endl;
    deallocate(head);
    return 0;
}
