#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 struct DOB
 {
     int dd;
     int mm;
     int yyyy;
 } ;

  struct KYC_DATA
 {

     //char pan_num[10] ;
     //char adhaar_num[12] ;
     //char locality[40] ;
     char pincode[6] ;
     struct DOB *dt_of_brth;
 };

 struct BANK_SUBSCRIBERS
 {
     char acctNum[10];
     char name[20] ;
     double balance ;
     struct KYC_DATA kyc_data ;
 
 } ;

 typedef struct BANK_SUBSCRIBERS account_holders ;
 typedef struct KYC_DATE customer_kyc ;
 typedef struct DOB dob ;

 //function signature
  void credit_into_account(struct BANK_SUBSCRIBERS *subscribers,int n) ; //+
  void debit_from_account(struct BANK_SUBSCRIBERS subscribers[],int n) ;// -

 void display_all_subscribers (account_holders account_holders_list[],int n)
 {
    /*  printf(">>SELECT * FROM ACCOUNT_HOLDERS;\n\n");
     printf("NAME\t\tACCOUNT_NUMBER\t\tBALANCE\n"); */
     printf("-----------------------------------------------\n");
     printf("Name:%s\n",account_holders_list[0].name);
     printf("Account number:%s",account_holders_list[0].acctNum);
     printf("Pincode:%s",account_holders_list[0].kyc_data.pincode) ;
     printf("Day: %d Month: %d Year: %d ",account_holders_list[0].kyc_data.dt_of_brth->dd,account_holders_list[0].kyc_data.dt_of_brth->mm,
     account_holders_list[0].kyc_data.dt_of_brth->yyyy);
 }

void dislplay_pntr(account_holders *act_subs,int n) ;

int main(int argc,char*argv[])
{
 //define array of Structures
account_holders account_holders_list[2] ;

printf("Enter the deatils\n") ;
for(int i =0;i< 1; i++)
{
    printf("Enter the account number: ");
    scanf("%s",account_holders_list[i].acctNum) ;
    printf("Enter the account holders' name: ");
    fflush(stdin) ;
    scanf("%s",account_holders_list[i].name) ;
    printf("Enter the balance:") ;
    scanf("%lf",&account_holders_list[i].balance) ;
    printf("Enter the KYC data:\n") ;
    printf("Enter pincode: ");
    scanf("%s",account_holders_list[i].kyc_data.pincode) ;
    //Defining a DOB structure
    dob d1; //int a
    //scanf("%d",&a);
    printf("Enter birth day:");
    scanf("%d",&d1.dd);
    printf("Enter birth month:");
    scanf("%d",&d1.mm);
    printf("Enter birth year:");
    scanf("%d",&d1.yyyy);
    //a=3 declare
    /* d1.dd = 3;
    d1.mm=8;
    d1.yyyy=1997; */
    //int *p declare
     dob *d;
    //p=&a
    d=&d1;
    //dynamic allocation
    account_holders_list[i].kyc_data.dt_of_brth = d ;
}


display_all_subscribers(account_holders_list,2) ;

return 0;
}

void credit_into_account(account_holders *subscribers,int n)
{
  //Account number->Search
  //current balance + credited amount
 //update new amount
 double credit=2000 ;

 double current = (subscribers+0)->balance ;//(subscribers[0]).balance
 double updated_bal = current + credit ;
 subscribers->balance = updated_bal ;
}