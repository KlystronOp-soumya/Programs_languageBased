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
 //scanf("%s", name) ;
 //scanf("%[^\n]s",name);
 gets(name);
 puts(name);
 name2 = name;//cant write this
 nm1=nm ;
 name="world" ;//error
 nm="world" ;
 //printf("Your name is : %s",name) ;
return 0;
}