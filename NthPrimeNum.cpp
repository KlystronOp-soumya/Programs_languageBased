//find the nth prime number
//say 4th prime is 7
//this is a brute force approach
//best implementation would be applying the Sieve method

#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n)
{
    bool flag = true;
    for (int i = 2; i <= n / 2; ++i)
    {
        if (n % i == 0)
        {
            flag = false;
            break;
        }
    }
    return flag;
}

int nthPrime(int term)
{
    int i = 0;
    int j = 2;
    int prime;
    while (i != term)
    {

        if (isPrime(j)) //true
        {
            prime = j;
            //cout << "Found prime: " << j << endl;
            i++;
            j++;
        }
        else
        {
            j++; //otherwise go to the next number
        }
    }

    return prime;
}
int main(int argc, char const *argv[])
{
    int n; //temr
    cin >> n;
    cout << nthPrime(n);
    return 0;
}
