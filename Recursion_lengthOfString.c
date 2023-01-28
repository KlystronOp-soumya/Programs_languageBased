/*
Recursive approach length of a string in c
base case if *str==NULL or'\0'
else
1+next character address()
*/
#include<stdio.h>

#include<stdlib.h>
int Strlen(char *str)
{
    //printf("%c,%u\n",*str,str);
    //fflush(stdin);
    //printf("Function called");
    static int count=0;
    if(*str=='\0')
     return 0;
    else
     {
       count++;
       1+Strlen(++str);//returning the address and checking for null
     } 
     
    
    return count;
}
int main(int argc,char *argv[])
{
 char str[]="Hello";
 /* fflush(stdin);
 gets(str);
 puts(str); */
 
 printf("length=%d",Strlen(str));
 return 0;
}