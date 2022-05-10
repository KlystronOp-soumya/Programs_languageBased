/*
this program finds the first missing element in the array
*/
#include <bits/stdc++.h>
using namespace std;

/* void delete_duplicates(vector<int> v)
{
    auto ip = unique(v.begin(), v.end());
    v.resize(distance(v.begin(), ip));
 }*/
int find_missing(vector<int> &v)
{
    //sort the array
    sort(v.begin(), v.end());
    //delete duplicates
    /* delete_duplicates(v); */
    int x = *v.begin();
    for (int i = 1; i < v.size(); i++)
    {
        x ^= v[i];
    }
    return x;
}
int main(int argc, char const *argv[])
{
    int n;
    vector<int> v(n);
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        int t;
        cin >> t;
        v.push_back(t);
    }
    int res = find_missing(v);
    cout << res;
    return 0;
}
