#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n'

class Agent
{
private:
    static double sCommissionRate;
    string mFirstName;
    string mLastName;
    string mAge;
    double mCommission;
    double mSalary;

public:
    Agent() {};
    // Constructor with the default parameter
    Agent(const string firstName, const string lastName, const string age, const double commission=0.00)
    {
        this->mFirstName = firstName;
        this->mLastName = lastName;
        this->mAge = age;
        this->mCommission = commission;
    };

    ~Agent(){};
    

    friend double calculateSalary(const double commRate, const double commAmt);

    void setFirstName(const string firstName)
    {
        this->mFirstName = firstName;
    }
    string getFirstName()
    {
        return this->mLastName;
    }
    void setLastName(const string lastName)
    {
        this->mLastName = lastName;
    }
    string getLastName()
    {
        return this->mLastName;
    }
    void setAge(const string age)
    {
        this->mAge = age;
    }
    string getAge()
    {
        return this->mAge;
    }
    void setCommission(const double comm)
    {
        this->mCommission = comm;
    }
    double getCommission()
    {
        return this->mCommission;
    }

    double getCommissionRate(){
        return this->sCommissionRate ;
    }
    void setSalary(const double salary){
        this->mSalary = salary ;
    }
    double getSalary(){
        return this->mSalary ;
    }
    void toString()
    {
        cout << END_LINE <<"Agent[FirstName=" << this->mFirstName << " ,LastName=" << this->mLastName << ",Age=" << this->mAge << " ,Commission=" << this->mCommission << "]";
    }

};

double Agent ::sCommissionRate = 0.8;

double calculateSalary(const double commRate, const double commAmt)
{
    return commAmt + (commAmt * commRate);
}

int main(int argc, char *argv[])
{

    // create object
    Agent agt("John", "Doe", "27", 5500.95);
    agt.toString();
    agt.setSalary( calculateSalary(agt.getCommissionRate() , agt.getCommission() ) );
    cout<< agt.getSalary();

    //create another agent using pointer
    Agent *pAgt = new Agent() ;
    pAgt->setFirstName("Linus") ;
    pAgt->setLastName("Torvalds") ;
    pAgt->setAge("68") ;
    pAgt->setCommission(98999.00) ;

    pAgt->toString();
    
    return 0;
}