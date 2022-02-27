#include<stdio.h>
/*
a-> &a[0]-> (a+0)
a[i]=>a+i
a[0]-> *(&a[0]) -> *(a+0) 
*(a+i)
*/

//void display(int *ar,int len);
void display(int *ar,int len)
{
    //int len = sizeof(ar)/sizeof(int) ;
    for(int i = 0 ; i<len ;i++)
    {
       // printf("%d ",ar[i]) ;
       printf("Address:%u\n",(ar+i));
       printf("Value:%d \n",*(ar+i));
    }
} 
int main(int argc, char const *argv[])
{
    int ar[5];
    int noe;
    scanf("%d",&noe);
    for(int i = 0 ; i<noe ;i++)
    {
        scanf("%d",ar+i);
    }
    display(ar,noe);//ar==&a[0]
    //display(&ar[0],noe);
    //display((ar+0),noe);
    return 0;
}
