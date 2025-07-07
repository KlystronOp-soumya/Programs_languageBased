/*
Exceptions in operator overloading
1.class member access operator(.,.*)
2.Scope resolution operator (::)
3.size of (sizeof())
4.Ternary/Conditional operator(?:)

syntax: return type classname :: operator op(arguments)
{
    //function body
}

i.member function
ii. friend function

The operation for overaloading:
1. create a class that defines the data tyoe this is to be used in the overloading operation
2. Decalre the operator function operator op() in the public part.
3. Define the operator function to implement the functionality

*/

#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class UnaryOptOvrLoad
{
    private:
    int x,y,z ;

    public:
    //constructors
    //overloaded
    UnaryOptOvrLoad(){} ; //default
    UnaryOptOvrLoad(int a, int b, int c) ; //parametarized
    UnaryOptOvrLoad (int a, float b) ;

    void getData(int a,int b,int c)
    {
        x = a ;
        y = b ;
        z = c ;
    }

    void display (void)
    {
        cout<< "x: " << x << endl ;
        cout<< "y: " << y << endl ;
        cout<< "z: " << z << endl ;
    }

    //operator overloading
    // - was overloaded as member function
    //void operator -() ;
    //as friend function
    friend void operator -(UnaryOptOvrLoad &opt) ; 
} ;

//constructor
UnaryOptOvrLoad :: UnaryOptOvrLoad(int a, float b)
{
    x = a ;
    y= b;
    z = 0 ;//initializing
}

//defining the overloaded function
/* void UnaryOptOvrLoad :: operator -()
{
    x = -x ;
    y = -y ;
    z = -z ;
} */

 void operator -(UnaryOptOvrLoad &opt)
{
    opt.x = -opt.x ;
    opt.y = -opt.y ;
    opt.z = -opt.z ;
}
int main(int argc,char*argv[])
{
//object
UnaryOptOvrLoad opt1 ;
opt1.getData(10,-13,100) ;

UnaryOptOvrLoad opt2 (13,2.5) ;

cout << "opt1: " ;
opt1.display() ;

//unary operator
//-opt1 ;

operator-(opt1) ;

cout << "opt1: " ;
opt1.display() ;

return 0;
}