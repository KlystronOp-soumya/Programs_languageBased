/*
Following is the algorithm to find all the prime numbers less than or equal to a given integer n by the Eratosthene’s method:

1.Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
2.Initially, let p equal 2, the first prime number.
3.Starting from p2, count up in increments of p and mark each of these numbers greater than or equal to p2 itself in the list. These numbers will be p(p+1), p(p+2), p(p+3), etc..
4.Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void sieve_prime(int n)
{
   int primes[n+1],i,p;
   int l=n+1;
   memset(primes,1,l*sizeof(int));

  /*  for( i=0;i<n+1;i++)
   printf("%d ",primes[i]); */

   for( p=2;p*p<=n;p++)
   {
       if(primes[p]==1)
       {
           for( i=p*p;i<=n;i+=p)
           primes[i]=0;
       }
   }
   for( p=2;p<=n;p++)
    if(primes[p]==1)
     printf("%d ",primes[p]);
}
int main(int argc,char *argv[])
{
    int n=atoi(argv[1]);
    printf("Prime numbers upto %d are::\n",n);
    sieve_prime(n);
    return 0;
}