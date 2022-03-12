#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

#define MAX_ELEM 100
 

 char *strrev_impl(char *str)
 {
     char *rev_str = NULL ;
    //dynamic memory allocation
    rev_str = (char *)malloc(sizeof(char)*strlen(str));
    int i ,j = 0;
    for(i = strlen(str)-1 ; i>=0 ;i--,j++ )
    {
        
        rev_str[j] = str[i] ;
        //printf("Character scanned: %c\n",rev_str[j]) ;
    }
    j++;
    rev_str[j]='\0' ;
    
    return rev_str ;

 }

 
int main(int argc,char*argv[])
{
 char str [MAX_ELEM]  ;
 printf("Enter a String: ");
 scanf("%[^\n]s",str);
 //printf("Reversed string: %s",strrev(str)); //lib function
 printf("Rev: %s ",strrev_impl(str));
return 0;
}