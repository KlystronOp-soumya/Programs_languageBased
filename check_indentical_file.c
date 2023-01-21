/*
Program to check whether the two files are same or not
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

#define TRUE 1
#define FALSE 0

int compare_files(FILE*fp1, FILE *fp2)
{
    printf("Called");
    char ch1,ch2 ;
    int flag = 1;
    //
     do
    {
         printf("here");
        ch1=fgetc(fp1) ;
        ch2=fgetc(fp2) ;
        if(ch1 != ch2)
        {
            printf("indifference found for: %c<->%c\n\n",ch1,ch2);
            return FALSE;
        }
        flag=0;
    }while((!feof(fp1)) && (!feof(fp2)));
    //if here because of file ending
    //further check which file ended
    if(flag!=1)
     return FALSE;
    else
     return TRUE;
}
//to open the file
FILE* open_file(const char* file_name)
{
    FILE *fp;
    char ch1;
    if((fp=fopen(file_name,"r"))!=NULL)
    {
        return fp;
    }
    else
     return NULL;
}
 
 void close_files(FILE *fp1,FILE *fp2)
 {
    printf("Closing Files");
    rewind(fp1);
    rewind(fp2);
    fclose(fp1);
    fclose(fp2);

 }
int main(int argc,char*argv[])
{
    FILE *fp1=NULL,*fp2=NULL;

    if(argc < 2 )
    {
        printf("Less number of arguments has been provided");
        exit(EXIT_FAILURE) ;
    }

    if((fp1=open_file(argv[1]))!=NULL)
    {
        printf("file : %s opened successfully\n",argv[1]);
    }
    else
    {
        printf("Error while opening file: %s\n",argv[1]);
        exit(EXIT_FAILURE) ;
    }
    
    if((fp2=open_file(argv[2]))!=NULL)
    {
        printf("file : %s opened successfully\n",argv[2]);
    }
    else
    {
       printf("Error while opening file: %s\n",argv[2]);
       exit(EXIT_FAILURE) ;
    }
    if(!compare_files(fp1,fp2))
        printf("different files\n");
    else
        printf("Similar files\n");
    close_files(fp1,fp2);
return 0;
}