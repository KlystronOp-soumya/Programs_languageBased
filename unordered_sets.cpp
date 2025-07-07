#include<bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    unordered_set<int>s;
    unordered_multiset<int>ms;
    s.insert(11);
    s.insert(11);
    for(int i=12;i<=20;++i)
    {
        s.insert(i);
    }
    for(auto itr=s.begin();itr!=s.end();++itr)
    {
        cout<<*itr<<" ";
    }
    cout<<"\n";

    ms.insert(11);
    ms.insert(11);
    for(int i=12;i<=20;++i)
    {
        ms.insert(i);
    }
    for(auto itr=ms.begin();itr!=ms.end();++itr)
    {
        cout<<*itr<<" ";
    }
    cout<<"\n";
    return 0;
}
