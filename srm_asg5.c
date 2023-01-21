/*
Read characters unitl * 
change Lower to Upper vice versa
Count upper and lower case character
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 char *ch= malloc(sizeof(char)*1);
 //to count the upper case and lower case characters
 unsigned int lower_count=0, upper_count=0;//init
 
 do
 {
    scanf("%c",ch);
    //check for the case
    if(*ch >= 65 && *ch <=90)
    {
        printf("%c\n",*ch+32);
        upper_count++;
    }
    else if (*ch>=97 && *ch<=122)
    {
        printf("%c\n",*ch-32);
        lower_count++ ;
    }
    
 } while (*ch != '*');
 

printf("lower case char# %d upper case char# %d",lower_count,upper_count);

return 0;
}