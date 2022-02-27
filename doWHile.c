#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int a,i=1;
    int b = scanf("%d",&a) ;
    printf("scanned: %d\n",b);

    do
    {
       printf("This while loop executed for %d times\n",i);
       i++ ;
       a++ ;
    } while (a<5);

     for(int i = 0; i>a  ;i++)
    {
        printf("%d ",i);
    }
    
    return 0;
}
