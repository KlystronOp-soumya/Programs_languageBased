/*
Making a Garland of linkedList

1->2->3->4->5->X
|  |  |  |  |  
11 21 31 41 51
|  |
12 22
|  |
13 23 ...so on
*/

#include <bits/stdc++.h>
using namespace std;

//subnodes
typedef struct sub_node //vertical list structure
{
    int data;
    struct sub_node *next_subNode_add;
} S_node;
//main nodes
typedef struct main_thread //horizental list structure
{
    int data;
    struct main_thread *next_node_add;
    struct sub_node *sub_node_head; // this pointer holds the address of the vertical list nodes
} M_node;

void append_main_node(M_node **head, int val) //appending nodes in the main horizental node
//arguments are Horizental list node addresses and the value to be inserted
{
    M_node *temp, *r;
    if (*head == NULL)
    {
        temp = new M_node();
        temp->data = val;
        temp->next_node_add = NULL;
        temp->sub_node_head = NULL;
        *head = temp;
    }
    else
    {
        temp = *head;
        while (temp->next_node_add != NULL)
        {
            temp = temp->next_node_add;
        }
        r = new M_node();
        r->data = val;
        r->next_node_add = NULL;
        r->sub_node_head = NULL;
        temp->next_node_add = r;
    }
}

void append_sub_node(S_node **Shead, int val)
{
    S_node *temp, *r;
    if (*Shead == NULL)
    {
        temp = new S_node();
        temp->data = val;
        temp->next_subNode_add = NULL;
        *Shead = temp;
    }
    else
    {
        temp = *Shead;
        while (temp->next_subNode_add != NULL)
            temp = temp->next_subNode_add;

        r = new S_node();
        r->data = val;
        r->next_subNode_add = NULL;
        temp->next_subNode_add = r;
    }
}

void display(M_node *head)
{
    M_node *temp;
    temp = head;
    while (temp)
    {
        cout << temp->data << "--->";
        S_node *sub_t = temp->sub_node_head; //sub list type
        while (sub_t)
        {
            cout << sub_t->data;
            cout << "\n|\n";
            sub_t = sub_t->next_subNode_add;
        }
        cout << "X\n";
        temp = temp->next_node_add;
    }
    cout << "X\n";
}

void deallocate(M_node *head)
{
    while (head)
    {
        M_node *temp = head;
        S_node *stempH = head->sub_node_head;
        while (stempH)
        {
            S_node *temp = stempH;
            stempH = stempH->next_subNode_add;
            free(temp);
            //cout << "Sub List node deallocated\n";
        }
        head = head->next_node_add;
        free(temp);
        //cout << "Main list Node omitted\n\n";
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    M_node *head = NULL; //horizenral node
    for (int i = 1; i <= 5; ++i)
    {
        append_main_node(&head, i); //appending in the horzental node
    }

    M_node *temp = head;
    while (temp)
    {
        cout << "For node with data:" << temp->data << "\n";
        for (int i = 1; i <= 3; ++i)
        {
            int t;
            cin >> t;
            append_sub_node(&(temp->sub_node_head), t);
        }
        temp = temp->next_node_add;
    }
    display(head);
    deallocate(head);

    return 0;
}
