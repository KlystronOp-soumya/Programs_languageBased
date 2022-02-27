#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int res;
    char grade;
    printf("Enter the result: ");
    scanf("%d",&res);

    switch (res)
    {
    case (50+50) : printf("Highest Result");
        /* code */
        break;
    
    default: printf("Yet to be implemented");
        break;
    }
    return 0;
}
