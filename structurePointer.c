#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

//defining a structure
typedef struct STUDENT
{
    //structure members
   char name[30] ;
   int roll ;
   char sec ;
}Student ;

//function template
void display_struct(Student) ;
void display_struct_ptr(Student*) ;
 
int main(int argc,char*argv[])
{
    Student *pstd ;
  Student s1 = {"Abcd" , 12 , 'A'} ;
  Student s2 = {"Gdhi" , 13 , 'B'} ;
  display_struct(s1) ;
  pstd = &s2 ;
  printf("\n\n") ;
  display_struct_ptr(pstd) ;

  Student s3 ;
  fflush(stdin) ;
  printf("Enter the name: " ) ;
  scanf("%s" , s3.name) ;
  printf("Enter roll: ");
  scanf("%d" , &s3.roll) ;
  fflush(stdin) ;
  printf("Enter sec: ");
  scanf("%c" , &s3.sec) ;
  display_struct_ptr(&s3) ;
return 0;
}

void  display_struct(Student s) 
{
    printf("The details of the student is : \n") ;
    printf("Name=%s\nRoll=%d\nSection=%c" , s.name , s.roll , s.sec  ) ;
}

void display_struct_ptr(Student *s)
{
    printf("The details of the student is : \n") ;
    printf("Name=%s\nRoll=%d\nSection=%c" , s->name , s->roll , s->sec  ) ;
}