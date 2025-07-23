#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] " 
constexpr char END_LINE = '\n' ; 

typedef struct Employee{
    string empId ;
    string empName ;

    void showEmployeeDetails(){
        cout<< "[ID:" << this->empId << ", Name:" << this->empName <<"]" << END_LINE ;
    }

}Employee ;

void showEmpDet(Employee **emp){
    cout<< "[ID:" << (*emp)->empId << ", Name:" << (*emp)->empName <<"]" << END_LINE ;
}

int main(int argc, char* argv[])
{
    Employee emp ;
    emp.empId = "123" ;
    emp.empName ="John Doe";
    emp.showEmployeeDetails();
    Employee* pEmp = &emp;
    showEmpDet(&pEmp);
    free(pEmp) ;
    pEmp = nullptr ;
    return 0 ;
}