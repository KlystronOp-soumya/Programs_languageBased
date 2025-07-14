#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 

class Complex{

    private:
        double _x ;
        double _y ;
    public:
        Complex(){ }
        Complex(const double real , const double imag): _x{real} , _y{imag} {}
        Complex operator+(Complex) ;
        void display(void) ;
        // friend function is also possible
        friend Complex operator-(Complex , Complex) ; 
} ;

Complex Complex :: operator+(Complex c){
    Complex temp ;
    temp._x = this->_x + c._x ;
    temp._y = this->_y + c._y ;
    cout<< "invoked operator + " ;
    return temp ;
}

Complex operator-(Complex c1 , Complex c2){
    cout << "invoked operator - " ;
    return Complex( (c1._x - c2._x) , (c1._y - c2._y)  ) ;
}

void Complex :: display(void){
    cout << _x << " +j" << _y << END_LINE ;
}


int main(int argc, char* argv[])
{
    Complex c1,c2,c3 ;
    c1 = Complex(2.5 , 2.5) ;
    c2 = Complex(1.6 , 2.7) ;
    c3 = c1 + c2 ; // this is similart to c1.operator+(c2)
    c3.display() ;
    c3 = c3.operator+(c2) ; // this way we can also invoke the operator
    c3.display() ;
    Complex c4 ;
    c4 = c3 - c2 ;
    c4.display() ;
    return 0 ;
}