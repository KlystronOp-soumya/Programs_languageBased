#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class Complex
{
    float real,img;

    public:
     void input(float real, float imag)
     {
        this->real = real;
        this->img = imag;
     }

     friend Complex sum(Complex, Complex) ;
     void  show (Complex) const ;
};
 
 Complex sum(Complex c1, Complex c2)
 {
    //object new
    Complex c3;
    c3.real = c1.real + c2.real;
    c3.img = c1.img + c2.img ;

    return c3 ;
 }

 void Complex :: show(Complex cx) const
 {
    cout<< cx.real << " +j"<<cx.img<<"\n" ;
 }
int main(int argc,char*argv[])
{
 Complex A,B,C;

 A.input(3.1,5.5) ;
 B.input(2.7,1.3) ;

 C = sum(A,B) ; // C = A + B ;

 cout<<"C=";
C.show(C) ;

return 0;
}