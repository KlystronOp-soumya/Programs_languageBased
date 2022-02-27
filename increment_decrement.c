#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    
    int x=INT_MIN,i=0,j=0;
    printf("Prev: x=%d,i=%d",x,i);
    x=i++;
    printf("Curr: x=%d,i=%d",x,i);
    printf("Prev: x=%d,j=%d",x,j);
    x= ++j;
    printf("Curr: x=%d,j=%d",x,j);

    return 0;
}
