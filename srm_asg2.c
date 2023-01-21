#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

#define THRES_SAL 10000
 

typedef enum EMPLOYEE_BONUS{MALE=5,FEMALE=10,EXTRA=2} bonus; //% of bonus
typedef struct EMPLOYEE
{
  double curr_salary;//current salary 
  double bns_salary;//salary after bonsu
  double balance; //balance
  char gender[3];//gender of the employee
  bonus bns_perct;//current bonus percentage
  bonus bns_bnft;//extra bonus benefit
} employee;

void display(employee *emp)
{
  printf("Current Salary:%.3lf\n",emp->curr_salary);
  printf("Eligible for bonus amount: %d%%\n",emp->bns_perct);
  printf("Eligible for extra bonus: %d%%\n",emp->bns_bnft);
  printf("Balance: %lf\n",emp->balance);
  printf("Hiked salary: %.2lf\n",emp->bns_salary);
}
/*
This function calculates the bonus of the 
employee
If the employee is Male then gets 5%
if woman then gets 10%

if salary is less than 10K then gets additional 2% benefit
*/
void calculate_bonus(employee *emp)
{
  int perct;
  if(strcmpi(emp->gender,"M") == 0)
  {
     emp->bns_perct = MALE;
    //check for the salary
    if(emp->curr_salary > THRES_SAL)
    {
      //eligible for 5%
      emp->bns_bnft = 0;
      emp->balance = emp->curr_salary*( emp->bns_perct/(double)100);
      emp->bns_salary = emp->curr_salary + emp->balance;
    }
    else if(emp->curr_salary<=THRES_SAL)
    {
      emp->bns_bnft = EXTRA;
      emp->balance = emp->curr_salary* (emp->bns_perct/(double)100);
      emp->bns_salary = emp->curr_salary + emp->balance;
      //the extra 2% hike
      emp->balance=emp->bns_salary*(emp->bns_bnft/(double)100) ;
      emp->bns_salary+=emp->balance;
    }
  }
  else if(strcmpi(emp->gender,"FM") == 0)
  {
    emp->bns_perct =FEMALE ;
    //check for the salary
    if(emp->curr_salary > THRES_SAL)
    {
      //eligible for 5%
      emp->bns_bnft = 0;
      emp->balance = emp->curr_salary*(emp->bns_perct/(double)100);
      emp->bns_salary = emp->curr_salary + emp->balance;
    }
    else if(emp->curr_salary<=THRES_SAL)
    {
      emp->bns_bnft = EXTRA;
      emp->balance = emp->curr_salary*(emp->bns_perct/(double)100);
      emp->bns_salary = emp->curr_salary + emp->balance;
      //the extra 2% hike
      emp->balance=emp->bns_salary*( emp->bns_bnft/(double)100) ;
      emp->bns_salary+=emp->balance;
    }
  }
  else
   exit(EXIT_FAILURE);
}
//Driver function
int main(int argc,char*argv[])
{
  employee emp;
  printf("Enter salary of the Employee:");
  scanf("%lf",&emp.curr_salary);
  printf("Enter the gender of the Employee(M/FM):");
  fflush(stdin);
  gets(emp.gender);

  //calculate bonus
  calculate_bonus(&emp);
  display(&emp);

return 0;
}