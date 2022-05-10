/*
16 is power of two
check: (16)2=00010000
  16-1=(15)2=00001111
------------------------
(and) 00000000(so it is the power of two)
if anything but two then the number is not power of two
*/

#include <bits/stdc++.h>
using namespace std;

bool isPowerOfTwo(int n)
{
    bool t = n & (n - 1);

    return t;
}

int main(int argc, char const *argv[])
{
    /* code */
    int n;
    cin >> n;
    /*
    int ar[]={2,4,6,3,5,11,10,12,16,32,64};
    */
    bool res = isPowerOfTwo(n);
    if (res == false)
        cout << "Power of two";
    else
        cout << "Not power of two";
    return 0;
}
