#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 
class Complex
{
    private:
    float real,imag;

    public:
     Complex() {} ;
     Complex(float real, float imag)
     {
        this->real = real ;
        this->imag = imag ;
     }

     Complex operator+ (Complex) ;
    void display()
    {
        cout<<this->real <<"+j" << this->imag <<'\n' ;
    }
} ;

//opertor overloading
Complex Complex ::  operator+(Complex c)
{
    Complex temp ;
     temp.real = this->real + c.real ;
     temp.imag = this->imag + c.imag ;

     return temp ;

    // return Complex((this->real + c.real), (this->imag + c.imag)) ;
}

int main(int argc,char*argv[])
{

Complex c1 (1,2) ;
Complex c2 (3,5) ;
Complex c3 ;

c3 = c1 + c2 ;

cout << "c1:" ;
c1.display() ;
cout << "c2:" ;
c2.display() ;
cout << "c3:" ;
c3.display() ;

return 0;
}