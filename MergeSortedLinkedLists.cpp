//Merging two linked list sorted

#include <bits/stdc++.h>
using namespace std;

typedef struct linked_list_node
{
    int data;
    struct linked_list_node *next_address;
} ll_node;

void init(ll_node *head)
{
    if (!head)
        head = new ll_node();
}
void traverse(ll_node **temp)
{
    while ((*temp)->next_address != NULL)
        *temp = (*temp)->next_address;
}
void append_node(ll_node **head, int val)
{
    ll_node *temp, *r;
    if (!*head)
    {
        temp = new ll_node();
        temp->data = val;
        temp->next_address = NULL;
        *head = temp;
    }
    else
    {
        temp = *head;
        //traverse to the last node
        traverse(&temp);
        //debigging;
        cout << "Data at the last node: " << temp->data << '\n';

        r = new ll_node();
        r->data = val;
        r->next_address = NULL;
        temp->next_address = r;
    }
}

ll_node *merge_sorted_lists(ll_node *head1, ll_node *head2)
{
    ll_node *temp1, *temp2;
    temp1 = head1;
    while (temp1)
    {
        if (temp1->next_address->data > head2->data)
        {
            temp2 = head2;
            traverse(&temp2);
            temp2->next_address = temp1->next_address;
            temp1->next_address = head2;
            break;
        }
        temp1 = temp1->next_address;
    }

    return head1;
}

void display(ll_node *head)
{
    while (head)
    {
        cout << head->data << ' ';
        head = head->next_address;
    }
}
void deallocate(ll_node *head)
{
    while (head)
    {
        ll_node *temp = head;
        head = head->next_address;
        delete temp;
    }
}
int main(int argc, char const *argv[])
{
    /* code */
    ll_node *head1 = NULL, *head2 = NULL;
    init(head1);
    init(head2);

    //append
    append_node(&head1, 1); //pass by reference since the head address will not be changed
    append_node(&head1, 2);
    append_node(&head1, 3);
    append_node(&head1, 6);
    append_node(&head1, 7);

    append_node(&head2, 4);
    append_node(&head2, 5);

    display(head1);
    cout << endl;
    display(head2);
    cout << endl;
    //merge the lists
    head1 = merge_sorted_lists(head1, head2);
    cout << "after merging" << '\n';
    display(head1);
    deallocate(head1);
    deallocate(head2);
    return 0;
}
