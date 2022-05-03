#include<stdio.h>
#include<string.h>
int main(int argc,char*argv[])
{
 //strcat
    char str1[6]="hello" ;
    char str2[7]="_world" ;

    strcat(str1,str2);

    printf("Concatenated: %s",str1) ;

return 0;
}
