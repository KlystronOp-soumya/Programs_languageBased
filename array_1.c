#include<stdio.h>

int main(int argc, char const *argv[])
{
    int a[] ={1,2,3,4,5,6};
    int b[5]={11,12,13,14,15};
    int c[]={0};
    int d[5]={0};//partial allocation
    int l;
    scanf("%d",l);
    float e[l] ;
    printf("The size of array a: %d\n",sizeof(a)) ;

    int len = sizeof(a)/sizeof(int) ;

    for(int i = 0; i<len;i++)
    {
        printf("%d ",a[i]);
    }

    return 0;
}
