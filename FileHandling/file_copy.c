/*Program to show the file copy
Input: a.exe src.txt dest.txt
*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{

FILE *fp_src , *fp_dest ;

//check for the proper argument numbers
if(argc < 3)
{
   fprintf(stderr , "Very less number of arguments") ;
   exit(1) ;
}

fp_src = fopen(argv[1] , "r") ; //source file in read only mode
fp_dest = fopen(argv[2] , "a") ; // destination file in append mode

if(fp_src == NULL)
{
   fprintf(stderr , "can not open source file: %s " , argv[1] ) ;
   exit(1) ;
}

if(fp_src == NULL)
{
   fprintf(stderr , "can not open destination file: %s " , argv[2] ) ;
   exit(1) ;
}

int status = copy_file(fp_src , fp_dest) ;

fclose(fp_src) ;
fclose(fp_dest) ;
return 0;
}