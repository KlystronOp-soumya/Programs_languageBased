//This program finds the two unique number in an array
/*
First we take XOR of all elements of array.
Suppose we have: 1,1,2,3,3,4,4,5,6,6
On taking XOR of all elements, this will remove duplicates elements as A ^A =0
Then we get: 2^5 from above result
The result of 2^5 will definitely have at least a set bit, to find the rightmost set bit we do res&1 and make a count to take the record of current position. If we get a non-zero res&1 that's the position we want to get, break the loop, otherwise right shift the res and increment the count.
Make a mask using 1<<count, and take & one by one with all elements, Elements resulting a non zero result of mask &arr[i], take XOR of them .
Resulting XOR will result in firstNo.
Now for SecondNo, take XOR of firstNo with initial res. i.e., firstNo^ firstNo ^ secondNo.
*/
#include <bits/stdc++.h>
using namespace std;

int findRightMostBit(int x)
{
    int i = 0;
    while (x > 0)
    {
        if (x & 1)
        {
            return i;
        }
        x >> 1;
        i++;
    }
    return i;
}

void findUnique(int arr[], int size)
{
    int res = 0;
    for (int i = 0; i < size; ++i)
    {
        res = res ^ arr[i];
    }

    int bitPos = findRightMostBit(res);
    int mask = (1 << bitPos);
    int firstNo = 0;
    for (int i = 0; i < size; ++i)
    {
        if ((mask & arr[i]) != 0)
        {
            firstNo = firstNo ^ arr[i];
        }
    }
    int secondNo = firstNo ^ res;
    cout << "Two Unique Numbers : " << firstNo << " , " << secondNo;
}

int main()
{
    int n;

    cout << "Enter size of array : ";
    cin >> n;

    int arr[n];

    cout << "Enter elements of array : \n";
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }

    findUnique(arr, n);

    return 0;
}
