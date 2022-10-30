#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 
 
int postfix_evaluation(char expression[], stack<int> st)
{
    int i,topElement,secondTopElement;

    for(i=0;expression[i]!='\0' ;i++ )
    {
        if(isdigit(expression[i]))
            st.push(expression[i]-'0') ;
        else
        {
            topElement = st.top();
            st.pop();
            secondTopElement = st.top() ;
            st.pop() ;

            switch (expression[i])
            {
            case '+' :st.push(topElement + secondTopElement);
                       break;
            case '-' : st.push(topElement-secondTopElement) ;
                        break ;
            case '*': st.push(topElement*secondTopElement) ; 
                        break ;
            
            default:
                break;
            }
        }
        
    }

}
 
int main(int argc,char*argv[])
{
 
return 0;
}