#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class A
{
    public:
        int m ;
    
    public:
     void show() ;
} ;

void A:: show()
{
    cout<< "The value of m : " << m ;
}
 
int main(int argc,char*argv[])
{
 
 int A :: *ip = &A :: m ;
 //thi will not work
 // int *ip = m;

 //creating object
 A a;
 a.m = 13 ;
 cout<< "m= " << a.m ;
 cout<< "m=" <<a.*ip ;
  
 A * aObj = &a ; // pointer to object

 cout<< aObj->m<< endl ;
 cout << aObj->*ip ;

return 0;
}