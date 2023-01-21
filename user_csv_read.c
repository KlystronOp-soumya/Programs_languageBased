/*
This program reads a CSV file
and maps the data with Structure
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 typedef struct _lib_members
 {
     char name[30];
     char age[2];
     char address[100];
     char pincode[6];
 }MEMBERS ;
 
 FILE * read_file(char *file_path) ;
 void map_members(FILE*fp,MEMBERS *mem) ;
int main(int argc,char*argv[])
{
 
return 0;
}