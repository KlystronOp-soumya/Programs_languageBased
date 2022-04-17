//Implementation of stack using Linked list !!WORKING
#include <bits/stdc++.h>
using namespace std;
//isEmpty
//push
//pop
//peek/top
typedef struct node
{
    int data;
    struct node *next_node_address;
} Node;

typedef struct Stack_st
{
    Node *top;
} St_adt;

void initialize_stack(St_adt **st) //if single pointer the return structure pointer
{
    *st = new St_adt();
    (*st)->top = NULL;
    // return st;
}

bool isEmpty(St_adt *st)
{
    return st->top == NULL;
}

void push(St_adt *st, int val) //addfront code
{
    Node *temp;
    temp = new Node();
    if (!temp)
    {
        cout << "Not possible";
        return;
    }

    temp->data = val;

    temp->next_node_address = st->top; //holds null initially
    st->top = temp;                    //now top points to the current created node.
    /*
     For the next iteration the temp would store new address of the 
     Node structure.Now temp->next_node_address would store the current 
     address held by top i.e. as done on the above line.So temp is now pointing to the 
     precious node.st->top=temp now shifted to the newly created structure.
    */
}

void peek(St_adt *st)
{
    if (!isEmpty(st))
        cout << "Top element is: " << st->top->data;
    else
    {
        cout << "Null";
        exit(1);
    }
}

void pop(St_adt *st)
{
    if (isEmpty(st))
        exit(1);

    Node *temp = st->top;                 //current address;
    st->top = st->top->next_node_address; //shifted to the next address
    cout << "Popped: " << temp->data;     //showing the element
    delete temp;                          //deleteing the node
}

void deallocate(St_adt *st)
{
    while (!isEmpty(st))
    {
        Node *temp = st->top;
        st->top = st->top->next_node_address;
    }
}
int main(int argc, char const *argv[])
{
    St_adt *st;
    initialize_stack(&st);
    //Push elements after successfull initialization of the
    for (int i = 0; i <= 6; ++i)
    {
        push(st, i);
    }

    peek(st);
    pop(st);
    /*  peek(st);
    pop(st);
    peek(st); */

    /*  if (st->top == NULL)
        cout << "Initialized";
    else
        cout << "Not Init"; */

    deallocate(st);
    /* 
    delete st->top;
    delete st; */

    return 0;
}
