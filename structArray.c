#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 struct BANK_SUBSCRIBERS
 {
     char acctNum[10];
     char name[20] ;
     double balance;
 } ;

 typedef struct BANK_SUBSCRIBERS account_holders ;
 
 void display_all_subscribers (account_holders account_holders_list[],int n)
 {
     printf(">>SELECT * FROM ACCOUNT_HOLDERS\n");
     printf("NAME\t\tACCOUNT_NUMBER\t\tBALANCE");
     printf("-----------------------------------------------");
     for(int  i=0;i<n;i++)
     {
         printf("%s\t%s\t%lf",account_holders_list[i].name,account_holders_list[i].acctNum,account_holders_list[i].balance) ;
     }
 }
int main(int argc,char*argv[])
{
 //define
account_holders account_holders_list[5] ;



return 0;
}