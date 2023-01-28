/*Recursive Digit Sum*/
#include<stdio.h>
#include<stdlib.h>

int recursive_digit_sum(int n)
{
    int rem,sum=0;
    //base case
    if(n%10==n)
    {
        return n;
    }
    else
    {
        while(n)
        {
            rem=n%10;
            sum+=rem;
            n=n/10;
        }
        printf("sum=%d\n",sum);
    }
    return recursive_digit_sum(sum);
    
}

int main(int argc,char * argv[])
{
    int n=atoi(argv[1]);

    printf("superdigit(%d)",recursive_digit_sum(n));
    return 0;

}