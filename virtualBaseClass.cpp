#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class student
{
    protected:
    int roll_number ;

    public:
     void get_number(int a)
     {
        roll_number = a ;
     }

     void put_number(void)
     {
        cout<< "Roll Number" << roll_number << "\n" ;
     }

} ;

class test : virtual public student
{
    protected:
     float part1,part2 ;

     public:
      void get_marks(float x, float y)
      {
        part1 = x;
        part2 = y ;
      }

      void put_marks(void)
      {
         cout<<"Marks obtained: "<<"\n"
             << "In Part1:  " << part1 <<"\n"
             <<"In Part2:   "<<part2<<"\n" ;
      }
};

class sports :  public virtual student
{
    protected:
     float score ;
    public:
     void get_score(float sc)
     {
        score = sc ;
     }
     void put_score(void)
     {
        cout<<"Sports score: " << score << "\n\n" ;
     }
} ;

class result: public test, public sports
{
    float total ;

    public:
     void display(void) ;
} ;

void result :: display(void)
{
    total = part1 + part2 + score ;

    put_number() ;
    put_marks() ;
    put_score() ;

    cout<< "Total Score: " << total << "\n" ;
};

int main(int argc,char*argv[])
{
 
return 0;
}