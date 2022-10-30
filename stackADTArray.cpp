//stack as an ADT
#include <bits/stdc++.h>
using namespace std;

//stack as structure
typedef struct stackADT
{
    int top;
    int *st;
} Stack; //capital since in cpp there is a stl named stack

void initialize(Stack *stk)
{
    stk->st = new int[100]; //say creating an array of 100 ints
    stk->top = -1;
}

void push(Stack *stk, int n)
{
    //check if the stack is overflowing
    if (stk->top == n)
    {
        cout << "Stack overflow";
        exit(0);
    }
    for (int i = 0; i < n; ++i)
    {
        int t;
        cin >> t;
        //stk->top++;
        stk->st[++(stk->top)] = t;
    }
}
void pop(Stack *stk)
{
    if (stk->top == -1)
    {
        cout << "stack underflow";
        exit(0);
    }
    int item = stk->st[stk->top];
    stk->top--;
    cout << "popped element: " << item<<endl;
}
void peek(Stack *stk)
{
    cout << "peek: " << stk->st[stk->top]<<endl;
}
void show(Stack *stk)
{
    if (stk->top == -1)
    {
        cout << "stack empty";
        exit(1);
    }
    for (int i = stk->top; i >= 0; --i)
    {
        cout << stk->st[i] << " ";
    }
}
void deallocate(Stack *stk)
{
    delete stk->st;
    delete stk;
}

int main(int argc, char const *argv[])
{
    //struct vari
    Stack *stk;
    //allocate a memory for the new structure
    stk = new Stack();
    //initialize the stack
    initialize(stk);
    //debugging print
    cout << "top=" << stk->top << endl;
    int n;
    cout << "Enter the number of elements in the stack:";
    cin >> n;
    //psuh into the stack
    push(stk, n);
    //debugging statement
    cout << "top=" << stk->top << endl;
    //displaying the stack
    show(stk);
    //pop
    peek(stk); //top element
    pop(stk);  //popped out
    show(stk); //after popped out
    peek(stk); //top element after pop

    //free memory
    deallocate(stk);

    //if garbage value then deallocation is done properly
    //cout << "top=" << stk->top;
    return 0;
}

//commented code to be inserted in main
/*  stk = new Stack();
    stk->top = -1;
    int n;
    cout << "Enter the number of elements in the stack:";
    cin >> n;
    //allocate memory for the array
    stk->st = new int[n];
    for (int i = 0; i < n; ++i)
    {
        cout << "Enter: " << i;
        int temp;
        cin >> temp;
        stk->st[i] = temp;
        stk->top += 1;
    }
    cout << "Displaying";
    for (int i = 0; i < n; ++i)
    {

        cout << stk->st[i] << endl;
    }
    delete stk->st;
    delete stk; */