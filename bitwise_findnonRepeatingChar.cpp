//Using bit mainpulation find the non repeating element in an array
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    int a[] = {1, 2, 3, 4, 3, 2, 1};
    int len = sizeof(a) / sizeof(a[0]);
    int val = 0;
    for (int i = 0; i < len; ++i)
    {
        val ^= a[i];
    }
    cout << val;

    return 0;
}
