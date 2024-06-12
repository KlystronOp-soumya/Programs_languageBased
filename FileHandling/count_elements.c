/* A simple file handling program to find out number words spaces and line in a file*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

//function to lines(\n) , words , spaces , punctuations
void count_elements( FILE * , int * , int * , int * , int *) ;

 
int main(int argc,char*argv[])
{
    FILE * fp ;
    int count_lines,count_letter,count_spaces , count_puncs ;
    count_lines=count_letter=count_spaces=count_puncs=0 ;
    int *lines ,*letters  ,  *spaces ,  *punctuations  ;
    lines=&count_lines ;
    letters=&count_letter ;
    spaces=&count_spaces ;
    punctuations = &count_puncs ;

    if(argc<2)
    {
         printf("Very Less arguments") ;
         exit(1) ;
    }

    fp=fopen(argv[1] , "r") ; //file name passed as the argumenet
     if(fp == NULL)
    {
        printf("Can not process the file: " ) ;
        exit(1);
    }
    count_elements(fp , lines , letters , spaces, punctuations) ; //called
    fprintf(stdout , "LINES:%-3d\nSPACES:%-3d\nCHARACTERS:%-3d\nPUNCTUATIONS:%-3d\r\n" , *lines , *letters , *spaces , *punctuations) ;
    fclose(fp) ;
return 0;
}

void count_elements(FILE *fp , int *lines , int *letters , int *spaces , int *punctuations)
{
    char letter ;
    if(fp == NULL)
    {
        printf("Can not process the file: " ) ;
        exit(1);
    }

    do
    {
       letter = fgetc(fp) ;      
       
       if(letter == '\n')//count lines
        (*lines)++ ; //increments the counter
       if(letter == ' ')//count spaces
        (*spaces)++ ;
       if(( letter >=65 && letter <= 90 ) || (letter >=97 && letter <= 122)) //count the letters
         (*letters)++ ;
       if (letter == ',' || letter == '.' || letter == ',' || letter == ';' || letter == ':' ) //count punctuations
          (*punctuations)++ ;
    if(letter == EOF) //check for the file ending
      break; 
    } while (1);
    printf("Processing was completed\n") ;
    
}