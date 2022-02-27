#include<stdio.h>

void display(int a[]);
void display2(int a[5],int len);
int main(int argc, char const *argv[])
{
    int ar[5];
    int *p;
    /* *p=10;
    printf("Size of pointer: %d",sizeof(p)); */
    int noe;
    scanf("%d",&noe);
    printf("main length:%d",sizeof(ar)/sizeof(int));//5
    for(int i = 0 ; i<noe ;i++)
    {
        scanf("%d",&ar[i]);
    }
    display(ar);
    display2(ar,noe);
    return 0;
}

void display(int ar[5])//int *a->&a[0]
{
    int len = sizeof(ar)/sizeof(int) ;//2
    printf("len=%d",len) ;
    for(int i = 0 ; i<=len ;i++)
    {
        printf("%d ",ar[i]) ;
    }
}

void display2(int a[5],int len)//pass by value
{
    for(int i = 0 ; i<=len ;i++)
    {
        printf("%d ",a[i]) ;
    }
}