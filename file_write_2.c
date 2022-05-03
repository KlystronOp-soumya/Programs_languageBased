#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 char str[80] ;
 FILE *fp;

 if((fp=fopen("lorem.txt","a+")) == NULL)
 {
     printf("File Not Found exception");
     exit(1) ;
 }

do
{
    printf("Enter a string to write: ") ;
    gets(str) ;
    strcat(str,"\n") ;
    fputs(str,fp) ;
} while (*str!='\n');

//placing the cursour in front
rewind(fp) ;

while(!feof(fp))
{
    fgets(str,79,fp) ;
    printf(str);
}
fclose(fp) ;

if(remove("lorem.txt"))
      printf("deleted");

return 0;
}