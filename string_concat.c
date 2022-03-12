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
 
int main(int argc,char*argv[])
{
 //strcat
    char str1[]="hello" ;
    char str2[7]="_world" ;

    //strcat(str1,str2);
    strcat_impl(str1,str2) ;

    printf("Concatenated (impl): %s",str1) ;

return 0;
}