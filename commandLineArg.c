#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc, char*argv[]) //command line arguments char **argv
{
    const int num ;
    printf("%d \n",num) ;
 
 //show the count of command line aruments
 printf("Number of total command line arguments: %d\n", argc);
 for(int i = 0;i < argc ; i++)
 {
     printf("%d arg: %s\n",i,argv[i]) ;
 }

return 0;
}