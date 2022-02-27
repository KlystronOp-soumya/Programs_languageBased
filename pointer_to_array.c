#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 
int main(int argc,char*argv[])
{
    int *ptr;
 int (*p)[4] ; //this is a pointer to an array of 4 elements
 int ar[]={1,2,3,4} ;
 p=&ar;//points to the entire array
 ptr=ar;//points to the first element of the array
for(int i =0;i<4;++i)
{
    
    printf("%d ",*(*p+i)) ;//p=&ar *p=*(&ar[])+i
    printf("\n\n");
    printf("%d ",*(ptr+i)) ;
}
return 0;
}