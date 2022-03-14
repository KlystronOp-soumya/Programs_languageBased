#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 char *strcat_impl(char *target, const char *source)
 {
     if( target == NULL || source == NULL)
     {
         printf("NullPointerException");
         EXIT_FAILURE ;
     }

    char *temp_target = target ; //copying the address
   // for(int i = 0 ; *temp_target != '\0' ;i++) ;
    while(*temp_target != '\0')
    {
        temp_target++ ;//final address would be the address of null character
    }

    while(*source != '\0')
    {
        *temp_target = *source ;
        temp_target++;
        source++;
    }
    *temp_target = '\0';

    return target ;

 }
 
 void xstringcat(char *target,char *source)
 {
     int i;  
     target=(char*)malloc(sizeof(char)*5) ;
     printf("Enter string: ") ;
    fflush(stdin);
    gets(target);
    source=(char*)malloc(sizeof(char)*1);
     printf("Enter another string: ");
     scanf("%[^\n]s",source);
     printf("You have entered: \"%s\" and \"%s\" \n",target,source) ;
    
    //realloc(target,strlen(source));

    for( i =0; target[i]!='\0';i++); //getting the last pos

    for(int j =0;j<strlen(source);j++,i++)
    {
        target[i] = source[j];
    }
    target[i]='\0'; //terminating
    printf("After concatenation: %s ",target) ;
 }
int main(int argc,char*argv[])
{
 //strcat
    char str1[]="hello" ;
    char str2[7]="_world" ;

    char*t=NULL,*s=NULL;
    //strcat(str1,str2);
   // strcat_impl(str1,str2) ;
     xstringcat(t,s);
    printf("Concatenated (impl): %s",str1) ;

return 0;
}