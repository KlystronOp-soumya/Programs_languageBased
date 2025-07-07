#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class item
{
    private:
      int num;//data members/ class variables
      double cost;
      void read(item obj); //private method
      
    public:
    void totalAmount(void);//calculates the total amount
    void getData(int number, double costings);
    void showdata(void){//inline method 
    //definingn member function inside the class definition
    cout << "The number is: "<<num<<" and cost is: "<<cost<<"\n" ;
    totalAmount() ;
    }
    void update(item obj)
    {
        read( obj);
    }
    
};
//Defining the memeber function outside of the Class definition
void item :: getData(int number,double costings)
{
    num = number;
    cost = costings ;
}
void item :: totalAmount(void)
{
    cout<<"The total amount is number*costings: "<< num * cost<<"\n" ;
}

void item :: read (item obj)
{
    cout<< "Enter values to update the item" ;
}

int main(int argc,char*argv[])
{
 
 item x,y,z ;

x.getData(20,100.50);
x.showdata();
x.update(x) ;

y.getData(10,50.0);
y.showdata();

return 0;
}