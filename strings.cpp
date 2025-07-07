#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    
    string str = "abc" ;
    for(int i = 0 ; i<= str.length() ; i++)
    {
        cout << str[i] ;
        if(str[i] == '\0') cout << "Y" ;
    }
    return 0 ;
}