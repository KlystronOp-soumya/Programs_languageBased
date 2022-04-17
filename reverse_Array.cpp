//Reverse an array
#include <bits/stdc++.h>
using namespace std;

void swap_t(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

vector<int> reverse_array(vector<int> v)
{

    //in place reversal without using any STL
    int mid = (v.size() / 2);
    int s = v.size() - 1;
    for (int i = 0; i < mid; ++i)
    {
        swap_t(&v[i], &v[s - i]);
        //swap(v[i],v[s-i]); 
    }

    return v;
}

int main(int argc, char const *argv[])
{
    /* code */
    vector<int> v;
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i)
    {
        int t;
        cin >> t;
        v.push_back(t);
    }
    v = reverse_array(v);
    for (const auto &c : v)
        cout << c << " ";
    return 0;
}
