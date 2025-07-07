#include<bits/stdc++.h>
using namespace std;

class Employee
{
    public:
        long int id ;
        string fname;
        string lname;

    Employee(long int id,string fname,string lname)
    {
        this->id = id;
        this->fname = fname ;
        this->lname = lname ;
    }

    private:
        double salary;
    
    
    public:
    void set_salary(double salary)
    {
        this->salary = salary;
    }

    double get_salary()
    {
        return this->salary ;
    }

    void display()
    {
        cout<<"Details of the current employee:: \n";
        cout<<this->id<<" "<<this->fname<<" "<<this->lname<<" "<<this->salary ;
    } 
    
};


int main(int argc, char const *argv[])
{
    Employee e1 = Employee(1,"AB","CB");
    e1.set_salary(20000);
    e1.display();
    return 0;
}
