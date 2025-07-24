#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] " 
constexpr char END_LINE = '\n' ; 

/*
    @brief class that implements stack adt
*/
class Stack{

    private:
        int *ar ;
        int top {} ;
        int size {} ;

    public:
        Stack(){}
        ~Stack(){
            if(this->ar != NULL){
                delete (this->ar) ;
                this->ar = nullptr ;
                if(top !=-1) top =-1 ;
                if(size > 0) size = -1 ;
            }
        }
        Stack(const int size): size{size} , top {-1} {
            this->ar = (int *) malloc(sizeof(int) * this->size) ;
        }
        int peek();
        int pop();
        void push();
};

int Stack :: peek(){

    if(this->top == -1){
        cerr << "Stack underflow" <<END_LINE ;
        exit(EXIT_FAILURE);
    }
    if(this->ar != NULL){
        return this->ar[top] ;
    }
    return INT_FAST64_MIN ;
}

int Stack :: pop(){

}

void Stack :: push(){
    
}

int main(int argc, char* argv[])
{
    

    return 0 ;
}