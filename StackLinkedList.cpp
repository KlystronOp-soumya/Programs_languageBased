#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *next_node_address;
} stack_node;

stack_node *top; //global defination of the top

bool isEmpty()
{
    return top == NULL;
}

void push(int data)
{
    /* if (top == NULL)
    {
        printf("Stack Overflow");
        exit(1);
    } */
    stack_node *temp;
    //get the address from the heap
    temp = new stack_node();
    temp->data = data;
    temp->next_node_address = top;
    top = temp;
}

void peek()
{
    printf("Peak Element: %d", top->data);
    return;
}

void pop()
{
    if (isEmpty())
    {
        printf("Stack Underflow");
        exit(1);
    }
    int item = top->data;
    //shift top below
    stack_node *temp;
    temp = top; //storing the current address

    top = top->next_node_address;
    free(temp);
    printf("popped:%d", item);

    return;
}

void display()
{
    printf("Stack elements are: ");
    stack_node *temp = top;
    while (temp)
    {
        printf("%d\n", temp->data);
        temp = temp->next_node_address;
    }
}
void deallocate()
{
    while (top)
    {
        stack_node *temp = top;
        free(temp);
        top = top->next_node_address;
    }
}
int main(int argc, char const *argv[])
{

    for (int i = 0; i <= 15; ++i)
    {
        push(i);
    }
    peek();
    pop();
    peek();
    display();
    deallocate();
    return 0;
}
