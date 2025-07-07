//demos unordered map in cpp
#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    vector<int> arr ;
    unordered_map<int , int> map1 ;
    unordered_map<int , int> map2 ;
    int n , t ;
    cin>> n ;
    while(n)
    {
        cin >> t ;
        arr.push_back(t) ;
        n-- ;
    }

    map1.insert(pair<int, int>(1 , 10) ) ;
    map1[2] = 11 ;
    map1[3] = 12 ;
    map1.insert(make_pair(4 , 13)) ;
    for(auto x : map1)
    {
        cout << x.first << ":" << x.second << endl ;
    }

    //print the frequency of the elements inside the array
    for(auto &x : arr)
    {
        map2[x]++ ; //map2[arr[i]]++
    }
    for(auto x : map2)
    {
        cout << x.first << ":" << x.second << endl ;
    }
 

    return 0 ;
}