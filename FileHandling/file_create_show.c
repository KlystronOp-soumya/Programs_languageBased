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
char content[80] ;
fp= fopen("mydoc.txt" , "w") ;
if(fp==NULL)
{
    printf("Error during openning the file") ;
    exit(EXIT_FAILURE) ;
}

//read from user
do
{
    fflush(stdin)  ;
    gets(content) ;
    
    if(strlen(content) == 0)
    {
      break ;
    }

    fputs(content , fp) ;



} while (1);
fclose(fp) ;
//read
fp = fopen("mydoc.txt" , "r") ;

while(fgets(content ,80 , fp) != NULL)
{
    fflush(stdout) ;
    puts(content) ;
}

fclose(fp) ;
return 0;
}