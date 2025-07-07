#include<bits/stdc++.h>
#include<cstring>
#define MAX_ELEM 100
using namespace std; 
 /*
 This class demonstrates that if an employee is eligble for the 
 bonus then bonus amount will be calculated
 */

 class Employee
 {
  
    //by default these are private
    //class variables
    private:
        static int total_eligible_employees;

    //declare the instance varibale
        char emp_name[30];
        char department[40];
        char designation[20];
        bool isELigibleForBonus;
        double salary;
        double bonus_amount;

    //constructor can be added
    //declare the functions
    //getters and setters are public method also the setters
    public:
        static double bonus_perct;
        void setEmp_Name(char *emp_name);
        void setDepartment(char* department);
        void setDesignation(char* designation);
        void setIsEligibleForBonus(const bool eligibility);
        void setSalary(const double salary);
        void setBonus_Amount(const double bonus_amount);

        char* getEmp_Name();
        char* getDepartment();
        char* getDesignation();
        bool  getIsEligibleForBonus();
        double getSalary();
        double getBonus_Amount();
        friend double calculate_bonus_amount(Employee& emp, double bonus_perct);
        void toString() //display or replicating Java
        {
           cout<<"The Employee object holds "
                "Name: "<<this->getEmp_Name()<<" "
                "Department: "<<this->getDepartment()<<" "
                "Designantion: "<< this->getDesignation()<<" "
                "Eligibility: "<<this->getIsEligibleForBonus()<<" "
                "Salary: "<<this->getSalary()<<" "
                "Bonus Amount: "<<this->getBonus_Amount()<<"\n" ;
           
        }
 };
        void Employee :: setEmp_Name(char *emp_name)
        {
            strcpy(this->emp_name,emp_name);
        }
        void Employee :: setDepartment( char* department)
        {
            strcpy(this->department,department);
        }
        void Employee :: setDesignation(char* designation)
        {
            strcpy(this->designation,designation);
        }
        void Employee :: setIsEligibleForBonus( bool eligibility)
        {
           this-> isELigibleForBonus = eligibility;

        }
        void Employee :: setSalary( double salary)
        {
            this->salary=salary;

        }
        void Employee :: setBonus_Amount( double bonus_amount)
        {   
            this->bonus_amount = bonus_amount;
        }

         char* Employee:: getEmp_Name()
            {
                return this->emp_name;
            }

        char* Employee:: getDepartment()
        {
            return this->department;
        }
        char* Employee:: getDesignation()
        {
            return this->designation;
        }
        bool Employee:: getIsEligibleForBonus()
        {
            return this->isELigibleForBonus;
        }
        double Employee:: getSalary()
        {
            return this->salary;
        }
        double  Employee:: getBonus_Amount()
        {
            return this->bonus_amount;
        }
double Employee :: bonus_perct = 0.15;
int Employee :: total_eligible_employees = 0;
double calculate_bonus_amount(Employee& emp,double bonus_perct)
{
    double calcBnsAmt=0.00;
    if(emp.getIsEligibleForBonus())
    {
        calcBnsAmt = emp.getSalary()*bonus_perct;
        cout<<"Bonus amout:"<<calcBnsAmt<<"\n";
        emp.setBonus_Amount(calcBnsAmt);
    }
    return calcBnsAmt ;
}
int main(int argc,char*argv[])
{
 
 //creating the  object
 //instancsiating
 Employee emp;
 char name[]="Soumya", desig[]="Dev",dept[]="MetLife" ;
 emp.setEmp_Name(name);
 emp.setDepartment(desig);
 emp.setDesignation(dept);
 emp.setIsEligibleForBonus(true);
 emp.setSalary(10000.00);
 emp.setBonus_Amount(0.00);
 emp.toString() ;
 calculate_bonus_amount(emp,emp.bonus_perct) ;
emp.toString() ;
 
return 0;
}