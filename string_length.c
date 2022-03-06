#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 int strlen_impl(const char *str)
 {
     int len =0 ;
    /* while(*str !='\0')
    {
        len++;
        str++ ;
    } */
    // for(; *str !='\0' ;len++,str++) ;
    for(len = 0;str[len]!='\0';len++);
     return len;
 }
 
int main(int argc,char*argv[])
{
 //lib func strlen
char *str;
str="Hello" ;
char str2[6]={'a','b','c','d','e','\0'} ;
printf("The length of the String: %d",strlen(str2));
printf("The length of the string is: %d",strlen_impl(str));

return 0;
}