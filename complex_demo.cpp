#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class Complex{
    private:
     float x,y ;
     static int count ;
    
    public:
    Complex(){
      count++ ;
    } //default constructor
    Complex(float a) // parameterized
    {
        count++ ;
        x=y=a ;
    }
    Complex(float real, float imag) ;
    /* {
        x= real ;
        y= imag ;
    } */
     Complex (Complex &c) ; //copy constructor

     ~Complex()
     {
        cout<< "Destructor was called"<<endl ;
        cout<< "Object was destroyed" ;
        count -- ;
     }

     void getTotalObjectCount ()
     {
        cout<< count ;
     }
    friend Complex sum(Complex cmplx1 ,Complex cmplx2 ) ;
    friend void show (Complex) ;
} ;

int Complex :: count = 0 ;
//constructor definit
Complex :: Complex (float real, float imag)
{
    x = real ;
    y= imag ;
}
Complex sum(Complex cmplx1 ,Complex cmplx2)
{
    Complex c3 ;
    c3.x = cmplx1.x + cmplx2.x;
    c3.y = cmplx1.y + cmplx2.y ;

    return c3 ;
}

Complex :: Complex(Complex &c)
{
    count++;
    x = c.x;
    y=  c.y ;
}
void show (Complex c)
{
    cout<< "Real: " << c.x << " Imag: " << c.y  <<endl ;
}
int main(int argc,char*argv[])
{
 
 Complex A (2.5, 3.5) ;//implicit
 Complex B (1.6) ; //explixit
 Complex C ;

 C= sum (A,B) ;
 
 //obj
 Complex D(C);// copy constructor is called

// D=C ;
 
 Complex E ;
 E= D; //copy constructor was not called ;

 Complex F = C ;// copy constructor was called 
 cout<< "A: " ; show(A) ;
 cout << "B: " ; show(B)  ;
 cout << "C: " ; show(C)  ;
 cout << "D: " ; show(D) ;
 cout<< "Total Objects created: " ; A.getTotalObjectCount() ;
 return 0;
}