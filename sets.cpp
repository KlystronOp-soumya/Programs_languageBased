//Set and functions
#include<bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    /* code */
    //define the iterator
    
    set<int,greater<int>>s; //if greater is specified then it shows the descending order
    set<int,greater<int>>::iterator itr;
    for(int i=11;i<=20;++i)
    {
        s.insert(i);
    }

    for(auto &c:s)
    {
        cout<<c<<" ";
    }
    cout<<'\n';

    
    set<int>s1(s.begin(),s.end());
    for(auto &c:s)
    {
        cout<<c<<" ";
    }
    cout<<"\n";

    for(auto &c:s)
    {
        cout<<c<<" ";
    }

    //erase an particular element
    //removing 101
    int removed_elem=s1.erase(101);
    cout<<"Removed:"<<removed_elem;//returns boolean
    //try to delete an element that is not present in set
    /* auto it = s1.erase(s1.find(105));
    if(it!=s1.end())
    {
        cout<<"Not found";
    } */
 cout<<"\n";
    //remove a range of elements
    s1.erase(s1.begin(),s1.find(15));
    for(auto &c:s)
    {
        cout<<c<<" ";
    }


s.clear();
s1.clear();

    return 0;
}
