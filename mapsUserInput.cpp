#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    map<int, int> mp;
    for (int i = 0; i < 5; ++i)
    {
        int temp;
        cin >> temp;
        mp[i] = temp;
    }

    for (auto &p : mp)
    {
        cout << p.first << " " << p.second << endl;
    }

    map<int, int> mp1;
    for (int i = 0; i < 5; ++i)
    {
        int t1, t2;
        cin >> t1 >> t2;
        mp1.insert({t1, t2});
    }

    for (auto &p : mp1)
    {
        cout << p.first << " " << p.second << endl;
    }

    map<int, int> mp2;

    for (int i = 0; i < 5; ++i)
    {
        int t1, t2;
        cin >> t1 >> t2;
        mp2.insert(make_pair(t1,t2));
    }

    for (auto &p : mp2)
    {
        cout << p.first << " " << p.second << endl;
    }

    return 0;
}
