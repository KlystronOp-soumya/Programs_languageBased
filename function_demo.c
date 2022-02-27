#include<stdio.h>
#include<stdlib.h>

/* Function prototype */
int sum(int a,int b);



int main(int argc, char const *argv[])
{
    /* code */
    /* printf("Provided number of command line arguments are: %d",argc );
    printf("Displaying the arguments: \n");
    for(int i=0;i<argc;++i)
    {
        printf("%s ",*(argv+i));
    } */
    int a = atoi(argv[1]);
    int b = atoi(argv[2]);
    
    printf("Sum of %d and %d is : %d",a,b,sum(a,b));
    printf("%d",sizeof(argv));
    return 0;
}
int sum(int a ,int b)
{
    return (a+b);
} 
