#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next;
} Node;

Node *add_front(Node *head, int val)
{
    Node *temp;
    if (head == NULL)
    {
        head = new Node();
        head->data = val;
        head->next = NULL;
    }
    else
    {
        temp = new Node();
        temp->data = val;
        temp->next = head;
        head = temp;
    }
    return head;
}

void display_forward(Node *head)
{
    Node *temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
}

void display_reverse_rec(Node *head)
{
    if (head == NULL)
    {
        return;
    }
    display_reverse_rec(head->next);
    cout << head->data;
}

void display_reverse(Node *head)
{
    stack<int> linked_list_elements;
    while (head)
    {
        linked_list_elements.push(head->data);
        head = head->next;
    }
    cout << "Size of the stack: " << linked_list_elements.size() << endl;
    while (!linked_list_elements.empty())
    {

        cout << linked_list_elements.top();
        linked_list_elements.pop();
    }
}

void dealloc(Node *head)
{
    while (head)
    {
        Node *temp;
        temp = head;
        head = head->next;
        delete temp;
    }
    delete head;
}
int main(int argc, char const *argv[])
{
    Node *st;
    st = NULL;
    for (int i = 0; i <= 6; ++i)
    {
        st = add_front(st, i);
    }
    cout << "List elementts in forward order: ";
    display_forward(st);
    cout << "List in reve(rec)" << endl;
    display_reverse_rec(st);
    cout << "List in rev(itr):" << endl;
    display_reverse(st);

    dealloc(st);
    return 0;
}
