#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "
constexpr char END_LINE = '\n';

typedef struct ListNode
{
    int data;
    struct ListNode *next;
} List;

typedef struct Stack
{
    List *top;
} Stack;

Stack *createStack()
{
    Stack *pStack = new Stack(); // similar to malloc
    pStack->top = nullptr;       // creates a blank list, does not hold any data
    return pStack;
}

void push(Stack *pStack, int data)
{
    List *temp;
    temp = new List();
    if (!temp)
    {
        cerr << "Memory error";
        return;
    }

    temp->data = data;
    temp->next = pStack->top;
    pStack->top = temp; // move the top to the next node
}

int pop(Stack *pStack)
{
    int data = INT_FAST8_MIN;
    ListNode *pTemp;
    if (pStack->top == nullptr)
    {
        cerr << "Empty stack";
        return INT_FAST8_MIN;
    }
    else
    {
        pTemp = pStack->top;
        data = pTemp->data;
        pStack->top = pStack->top->next;
        delete pTemp;
        pTemp = nullptr;
    }
    return data;
}

int peek(Stack *pStack)
{
    if (pStack->top == nullptr)
    {
        cerr << "Empty stack! can not peek ";
        return INT_FAST8_MIN;
    }
    else
    {
        return pStack->top->data;
    }
}

void deallocateStack(Stack *pStack)
{
    ListNode *currNodeOfStk;
    if (pStack != nullptr)
    {
        while (pStack->top != nullptr)
        {
            currNodeOfStk = pStack->top;
            pStack->top = pStack->top->next;
            delete currNodeOfStk;
            currNodeOfStk = nullptr;
        }
    }
}

int main(int argc, char *argv[])
{
    Stack *pStack = createStack();
    for (int i = 0; i < 5; i++)
    {
        push(pStack, i);
    }
    cout << pop(pStack) << END_LINE;
    cout << pop(pStack) << END_LINE;
    cout << pop(pStack) << END_LINE;
    cout << pop(pStack) << END_LINE;

    cout << peek(pStack) << END_LINE;
    cout << pop(pStack) << END_LINE;
    cout << peek(pStack) << END_LINE;
    return 0;
}