#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
 char names [3][15]={
      {'a','b','c','d','\0'},
     "efgh",
     "ijkl"
 } ;

int nums[3][3]={
    {1,2,3},
    {4,5,6},
    {6,7,8}
} ;
for(int i = 0;i<3;i++)
 printf("%d\n",names[i][0]) ;

for(int i = 0 ; i<3;i++)
{
    char *s = &names[i][0] ;//i=0 -> &"abcd"
    printf("%s\n",s) ;
}
int add  = 4210691 ;
    char *s1="soumik" ;//s=&"soumik"
    printf("%c\n",add) ;
    printf("%u\n",s1);

for(int i =0 ; ;i++ )
{
    printf("%c ",add) ;
}

for(int i =0;i<3;i++)
 for(int j =0;j<5;j++)
   printf("%c",names[i][j]) ;


/*  for(int i = 0 ; i< 3 ;i++)
  printf("%u\n",&nums[i][0]) ; */

return 0;
}