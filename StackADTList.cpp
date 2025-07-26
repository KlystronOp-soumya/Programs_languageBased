#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] " 
constexpr char END_LINE = '\n' ; 

typedef struct ListNode{
    int data ;
    struct ListNode* next;
} List ;

typedef struct Stack{
    List* top;
} Stack;

Stack* createStack(){
    Stack* pStack = new Stack() ; //similar to malloc
    pStack->top = nullptr ; //creates a blank list, does not hold any data
    return pStack ;
}

void push(Stack* pStack , int data){
    List *temp ;
    temp = new List() ;
    if(!temp){
        cerr << "Memory error" ;
        return ;
    }

    temp->data=data;
    temp->next=pStack->top;
    pStack->top = temp ; //move the top to the next node
}

int main(int argc, char* argv[])
{
    

    return 0 ;
}