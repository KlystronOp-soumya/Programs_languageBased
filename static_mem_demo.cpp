#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class item
{
   static int count ;
    int number ;

    public:
        void setdata(int a)
        {
            number = a;
            count++;
        }
        int getdata()
        {
            return number ;
        }
        void showdata()
        {
            cout<<number;
        }
        static void getcount(void)
        {
            cout<<"count:"<<count<<'\n';
        }

    //Demo pass by value and pass by reference
    void modifyNumber(int a);
    void modifyObject(item &obj) ;
} ;

//defining the static member
//initialized to 0
int item :: count= -1;

void item :: modifyNumber(int a)
{
    cout<<"Multiplying with 2: "<< a*2 << endl ;
}

void item :: modifyObject(item& obj)
{
    obj.number *=2 ;
    cout<<"(Obj)Multiplying with 2: "<< obj.number << endl ;
}

int main(int argc,char*argv[])
{
 
 item obj1,obj2,obj3 ;
 /* obj1.getcount();
 obj2.getcount();
 obj3.getcount(); */

item::getcount() ; //item.getcount()
 obj1.setdata(1);
 obj2.setdata(2);
 obj3.setdata(3);

/* obj1.getcount();
 obj2.getcount();
 obj3.getcount(); */

item :: getcount() ;

item obj_ar[4] ;

for(int i =0;i< 4; i++)
{
    item obj;
    obj.setdata(i) ;
    obj_ar[i] = obj ;
}

for(int i =0;i< 4; i++)
{
   obj_ar[i].showdata() ;
}

for(int i =0;i< 4; i++)
{

   obj_ar[i].modifyNumber(obj_ar[i].getdata()) ;
   cout<< "Here after modification the number: "  << obj_ar[i].getdata() <<endl;
   obj_ar[i].modifyObject(obj_ar[i]) ;
   cout<< "Here after object  modification the number: "  << obj_ar[i].getdata() <<endl;
}
return 0;
}