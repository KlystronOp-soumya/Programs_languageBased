#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 30
#define BREAK_LINE printf("\n")
#define DESTF_PREF "old_"

/*
typedef struct file_info
{
    char name_f[MAX_ELEM],ext_f[5];
 int fname_len = 0;
}finfo;
*/
//global declarations
char name_f[MAX_ELEM],ext_f[5];
int fname_len = 0;

void set_file_name_extension(const char *fname)
{
    int sep_index = 0 ; //indicates the extension seperator
    int j  =0;
    //getting the file name
    for(int i = 0 ; i <strlen(fname) ; i++)
    {
        if(*(fname+i) != '.')
        {
           // printf("Current scanned char:%c\n", *(fname+i));
            *(name_f+i)= *(fname+i) ; //name_f[i] = fname[i]
        }
        else
        {
            *(name_f+i)='\0';//ending the file name
            sep_index=i ;//getting the index of  the dot
            break;
        }        
    }
    //getting the extension
    while(*(fname+sep_index)!='\0') //positioning the pointer on the seperator fname[sep_index]
    {
        //printf("Char under processing: %c\n",*(fname+sep_index));
        ext_f[j]= *(fname+sep_index);
        sep_index++;
        j++;
    }
    ext_f[j]='\0' ;

 //set the file_name length
 fname_len = strlen(fname);
 //for(;name_f[fname_len]!='\0';fname_len++) ;
 //printf("file name length:%d",fname_len);
}

 FILE *read_file(FILE *fp, const char *fname)
 {
     if((fp=fopen(fname,"r+")) == NULL)
     {
         perror("The file can not be accessed");
         EXIT_FAILURE;
     }
     printf("File was read successfully\n");
     return fp;
 }
 
 void display_file(FILE * fp)
 {
     char ch;
     while (!feof(fp)) 
     {
         putchar(ch) ;
         if(!feof(fp))
          ch=(char)fgetc(fp) ;
     }
     
 }

 void move_file(FILE *fp,char *source_file_name)
 {
    FILE *dest_fp;char ch;
     char *dest_file_name;
     dest_file_name=(char*)malloc(sizeof(char)*(fname_len+5));
     dest_file_name=strcpy(dest_file_name,DESTF_PREF);
     dest_file_name=strcat(dest_file_name,source_file_name);
     //puts(dest_file_name);
    if((dest_fp=fopen(dest_file_name,"w+"))==NULL)
    {
        perror("Error creating the file");
        return;
    }
    ch=fgetc(fp);
    while(!feof(fp))
    {
        fputc(ch,dest_fp);
        if(!feof(fp))
         ch=fgetc(fp);
    }
    printf("File was moved!!");
    fclose(dest_fp);
    if(dest_fp!=NULL)
     free(dest_fp);
 }

 void copy_file(FILE *fp)
 {
     FILE *dest_fp;char ch;
     char *dest_file_name;
     dest_file_name = (char *)malloc(sizeof(char)*(fname_len+5));
     //memcpy(dest_file_name,name_f,strlen(name_f));
     dest_file_name=strcpy(dest_file_name,name_f);
     dest_file_name=strcat(dest_file_name,"_cpy");//abc_cpy
     dest_file_name=strcat(dest_file_name,ext_f);//abc_cpy.txt
     printf("Name of the destination file is: \n");
     puts(dest_file_name);

     //open the destination file in  the write mode
    if((dest_fp=fopen(dest_file_name,"a+"))==NULL)
    {
        perror("File can not be created");
        return ;
    }
    
    ch=fgetc(fp);
    while (!feof(fp))
    {
        fputc(ch,dest_fp); //write each char in the destination file
        if(!feof(fp))
            ch=(char)fgetc(fp);
    }
     fclose(dest_fp);
     if(dest_fp!=NULL)
      free(dest_fp) ;
     free(dest_file_name);
     printf("File copied successfully");
 }

 void delete_file (char *file_name)
 {
     remove(file_name);
     printf("File was deleted successfully");
 }

int main(int argc,char *argv[])
{
 FILE *fp = NULL;
 char *operation;

if(argc < 2)
{
    printf("Less arguments");
    EXIT_FAILURE;//exit(1) ;
}

char *file_name = argv[2];
//puts(file_name);
operation = argv[1] ;
//puts(operation);
set_file_name_extension(file_name);
fp = read_file(fp,file_name) ;

if(strcmp(strlwr(operation),"c") == 0)
{
    printf("Copy operation");
    BREAK_LINE;
    copy_file(fp);
}

if(strcmp(strlwr(operation),"m") == 0)
{
    printf("Move operation\n");
    move_file(fp,file_name);
    BREAK_LINE;
    fclose(fp) ;
    delete_file(file_name);
}

if(strcmp(strlwr(operation),"d") == 0)
{
    printf("delete operation");
    fclose(fp) ;
    delete_file(file_name) ;
}

if(strcmp(strlwr(operation),"s") == 0)
{
    printf("Dsipalying the contents of the file");
    BREAK_LINE;
   display_file(fp);
}
fclose(fp) ;
free(fp);
return 0;
}