/*Program to demostrate different operations with simple Library transactions*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
#define TRUE 1
#define FALSE 0
#define BREAK_LINE printf("\n")
//structure to define a Book
typedef struct BOOK_INFO
{
   char book_name[81] ; //name of the book
   char isbn_no[15] ; //ISBN code
   char author[30] ; // Author of the book
   int edition ; // Edition of the book
   int year ; //published year
   int copies_in_place ; //copies present in the library
}Book;

//structure to define the library member
typedef struct MEMBER_INFO
{
    char name[35] ;
    long issue_date ; //format YYYYMMDD
    Book *book ;
} Member ;

//function signatures
void insert_book_entries(FILE *fp , Book *) ;
void insert_book_issue(FILE *fp , Member *) ;
void copy_book_entry(FILE *src , FILE *dest) ;
void delete_entire_entry(FILE *fp) ;
 
int main(int argc,char*argv[])
{
 
return 0;
}