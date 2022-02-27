#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
    char str[]={'a','b','c','d','e','\0'} ;
    char str2[]="abcd" ;
    char str3[5]={'a','b','c','d','\0'} ;
    char *str4="Hello World" ;

    int l= sizeof(str)/sizeof(char);
    printf("The length of the string is : %d\n",l);

    /* for(int i =0;i<l;++i)
    {
        printf("%c",str[i]);
    } */
    for(int i =0;str[i]!='\0' ;++i)
    {
        printf("%c",str[i]);
    }
    printf("\n");
    for(int i =0;str2[i]!='\0' ;++i)
    {
        printf("%c",str2[i]);
    }
    printf("\n");
    
    int k =0;
    while(str4[k]!='\0')
    {
        printf("%c",str4[k]);
        ++k;
    }
    
    return 0;
}