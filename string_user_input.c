#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 char name[10] ;
 char name2[10] ;
 char *nm= "Hello" ;
 char *nm1;
 printf("Enter name: ");
 scanf("%s", name) ;
 //scanf("%[^\n]s",name);
 gets(name);
 puts(name);
 name2 = name;//cant write this
 nm1=nm ;
 name="world" ;//error
 nm="world" ;
 //printf("Your name is : %s",name) ;

 char str[20];
 char *s[5];//array of pointers-stores strings
 for(int j=0;j<5;j++)
 {
    fflush(stdin) ;
    gets(str);//str[20]
   s[j] = (char *) malloc(strlen(str)+1) ;
    strcpy(s[j],str);

 }
return 0;
}