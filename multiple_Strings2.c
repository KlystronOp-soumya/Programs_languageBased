#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 //strrev . strupr
 
int main(int argc,char*argv[])
{
 char *names[] ={
     "abcd",
     "efgh",
     "ijkl"
 } ;
 for(int i = 0 ;i<3;i++)
 {
     names[i]=strrev(names[i]) ;
     printf("%s\n",names[i]) ;
 }
return 0;
}