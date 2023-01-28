#include <stdio.h>
#include <stdlib.h>
void is_prime(int n)
{
    int i;
    int flag = 1;
    for (i = 2; i <= n / 2; i++)
    {
        if (n % i == 0)
        {
            flag = 0;
            break;
        }
    }
    if (flag)
        printf("%d is prime", n);
    else
    {
        printf("%d is not prime", n);
    }
}
int main(int argc, char *argv[])
{
    int n = 2;
    is_prime(n);
    return 0;
}