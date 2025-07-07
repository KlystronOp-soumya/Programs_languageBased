#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class Sample2 ; // forward declaration
class Sample
{
    private:
     int a,b;
    public:
        void setValue() //inline 
        {
            a=25;
            b=40;
        }
        //friend function
        //friend float getMean(Sample obj);
};

class Sample2
{
    private:
     int x,y;
    public:
        void setValue() //inline 
        {
            x=10;
            y=10;
        }
        //friend function
        friend float getMean(Sample2 obj);
} ;

float getMean(Sample2 s)
{
    return float(s.x + s.y) / 2.0 ;
}

int main(int argc,char*argv[])
{
 Sample X;
 X.setValue();
 //cout<<"Average is: "<< getMean(X)<<endl; 

 Sample2 Y;//object
  Y.setValue();
  cout<<"Average is: "<< getMean(Y)<<endl; 

return 0;
}