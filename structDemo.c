#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
typedef struct  DOB
 {
     int dd;
     int mm;
     int yyyy;
 } dob;
 
typedef struct STUDENT
 {
     /* data */
    char Name[30] ;
    int roll;
    char sec;
    double result;
    struct DOB date_of_birth;

 }Student;

//typedef struct STUDENT Student ;
void  getStudent(Student s1)
 {
     strcpy(s1.Name,"Soumik") ;
     printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",s1.Name,s1.roll,s1.sec,s1.result) ;
 } 

 void getStudentPointer (Student *st)//int *p
 {
     printf("address of this Structure object: %u",*st) ;
     printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",st->Name,st->roll,st->sec,st->result) ;
     printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",(*st).Name) ;
 }
int main(int argc,char*argv[])
{
  ;
  Student s1={"Abcs",13,'B',99.0} ;//initialization

printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",s1.Name,s1.roll,s1.sec,s1.result) ;

s1.result=80.0 ;
printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",s1.Name,s1.roll,s1.sec,s1.result) ;

strcpy(s1.Name,"Aishik");
printf("Name:%s\nRoll:%d\nSec:%c\nMarks:%lf\n",s1.Name,s1.roll,s1.sec,s1.result) ;

getStudent(s1) ;

Student s2={"Soumya",13,'B',89.4,{3,8,1997}} ;

printf("%s %d %c %lf %d %d %d",s2.Name,s2.roll,s2.sec,s2.result,s2.date_of_birth.dd,s2.date_of_birth.mm,s2.date_of_birth.yyyy) ;
getStudentPointer(&s2) ;
return 0;
}