#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 FILE * fp ;
 char acct_no[5] ;
 char bank_id [5] ;
 float balance ;
 int i = 1 ;
 fp = fopen("transaction_data.txt" , "w") ;

 do
 {
    fflush(stdin) ;
    gets(acct_no) ;
    fflush(stdin) ;
    gets(bank_id) ;
    fflush(stdin) ;
    scanf("%f" , &balance) ;

    fprintf(fp , "Account No. : %s\tBank Id: %s\tBalance: %2.3f\n",acct_no , bank_id , balance) ;
    i++ ;
 } while (i<=3);

fclose(fp) ;
return 0;
}