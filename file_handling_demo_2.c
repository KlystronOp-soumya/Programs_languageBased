#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
void write_file(FILE *fp)
 {
     char *str="Hello World" ;
     for(int i = 0; i< strlen(str);i++)
     {
         printf("%c ",str[i]) ;
         fputc(str[i],fp) ;
     }
 }
 
int main(int argc,char*argv[])
{
  //File
  FILE *fp ;
  char ch;

  if((fp=fopen("lorem.txt","a")) == NULL)
     {
         perror("The file can not be accessed");
         EXIT_FAILURE;//exit(1)
     }
     //write_file(fp) ;
     //rewind(fp) ;
      //ch = fgetc(fp) ;
      //printf("%c",ch) ;
     /*do
     {
        putchar(ch) ;
        ch=fgetc(fp) ;
     }while(ch != EOF) ; */

    while(!feof(fp))
    {
        ch=fgetc(fp) ;
        putchar(ch);
    }

     //close
    if(fclose(fp))
     printf("Closed");
    else 
     printf("Not Closed") ;


return 0;
}