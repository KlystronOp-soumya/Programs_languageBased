#include<stdio.h>
#include<stdlib.h>
#define MAX_S 100

int main(int argc, char const *argv[])
{
    //static alloc array
    int ar[MAX_S];
    int noe;
    printf("Enter the number of elements: \n");
    scanf("%d",&noe);
    if(noe>=100)
    {
        printf("Array size can not be more than 100 elems");
        exit(1);
    }
    for(int i = 0 ; i < noe ; i++)
    {
        int temp;
        printf("Enter %dth elem:\n",i);
        scanf("%d",&temp);
        ar[i]=temp;
    }
    printf("Displyaing the array:\n");
    for(int i = 0; i<noe;i++)
    {
        printf("%d ",ar[i]);
    }
    printf("Displaying the array in reverse:\n");
    for(int j=noe-1 ; j>=0 ;j--)
    {
        printf("%d ",ar[j]);
    }
    return 0;
}
