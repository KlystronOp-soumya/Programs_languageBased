#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class Number
{
    private:
     int x,y;
    public:
     void setNum(int,int) ;
     int getX();
     int getY();
     void modifyNum(int,int) ;
     void modifyNum(Number) ;
};

void Number :: setNum(int x,int y)
{
   this->x=x;
   this->y=y;
}

int Number :: getX()
{
    return this->x;
}

int Number :: getY()
{
    return this->y;
}

void Number :: modifyNum(int x,int y)
{
    x*=x;
    y/=y;
    cout<<"In function :: x =" << x << " y="<<y << endl;
}
void Number :: modifyNum(Number obj1)
{
 obj1.x*=2;
 obj1.y*=3 ;
    cout<<"In function :: x =" << obj1.x << " y="<<obj1.y << endl;
}

int main(int argc,char*argv[])
{
 
 //object
 Number obj,obj2;
 obj.setNum(2,4);
 cout<<"Before modification: x= "<< obj.getX() <<" y="<<obj.getY()<<endl ;
 obj.modifyNum(obj.getX(),obj.getY()) ;
 cout<<"After modification: x= "<< obj.getX() <<" y="<<obj.getY()<<endl ;

 cout<<"Pass by ref"<<endl;
 cout<<"Before modification: x= "<< obj.getX() <<" y="<<obj.getY()<<endl ;
 obj2.modifyNum(obj) ;
 cout<<"After modification: x= "<< obj.getX() <<" y="<<obj.getY()<<endl ;
return 0;
}