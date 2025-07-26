#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "
constexpr char END_LINE = '\n';

/*
    @brief Implementation of stack using dynamic array
*/
struct StackADT
{
    int top{};
    int capacity{};
    int *ar{};
    /* //the constructor can also be used

    StackADT(const int capacity): top {-1}, capacity {capacity} {
        this->ar = (int*)malloc(sizeof(int)* this->capacity) ;
    }
    */

    /*
   ~StackADT(){
    //deallocate
    if(this->ar != nullptr || this->ar == NULL)
        delete this->ar ;
        this->ar = nullptr ;
   }
    */
};
typedef struct StackADT Stack;

Stack *createStack(const int capacity)
{

    Stack *pStack = (Stack *)malloc(sizeof(Stack));
    if (pStack == nullptr)
    {
        cerr << "Memory allocation issue!" << END_LINE;
        return nullptr;
    }
    pStack->capacity = capacity;
    pStack->top = -1;
    pStack->ar = (int *)malloc((pStack->capacity) * sizeof(int));

    if (pStack->ar == nullptr)
    {
        return nullptr;
    }

    return pStack;
}
/*
    @brief check if the stack is empty
*/
bool isEmpty(const Stack *pStack)
{

    return (pStack->top == -1);
}
/*
    @brief get the current size of the Stack
*/
int size(const Stack *pStack)
{
    return (pStack->top + 1);
}
/*
    @brief checks if the Stack is full
    @returns true or false
*/
bool isFull(const Stack *pStack)
{
    return (pStack->top == pStack->capacity - 1); // 0 based index
}

void push(Stack* pStack , int data){
    if(pStack != nullptr){
        if( isFull(pStack)){
            resize(pStack) ;
        }
        pStack->ar[ pStack->top] = data ;
        pStack->top++ ;
    }
}

void deleteStack(Stack* pStack){

}

int pop(Stack* pStack){
    if(isEmpty(pStack)){
        cerr << "Stack is empty" ;
        return INT_FAST8_MIN ;
    }
    int data = pStack->ar[pStack->top] ;
    pStack->top--;
}

int peek(const Stack* pStack){

    if(pStack->top != -1) return pStack->ar[pStack->top] ;
    else{
        cerr << "Stack is empty!";
        return INT_FAST8_MIN ;
    }
}

void deleteStack(Stack* pStack){
    if(pStack){
        if(pStack->ar != nullptr)
        {
            delete pStack->ar ;
        }
        delete pStack ;
    }
}


void resize(Stack *pStack)
{
    pStack->capacity = pStack->capacity * 2;
    pStack->ar = (int *)realloc(pStack->ar, (pStack->capacity * sizeof(int)));
}

int main(int argc, char *argv[])
{

    return 0;
}