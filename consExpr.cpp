#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    const double x {1.2} ;
    const double y {3.4} ;
    const double z {x+y} ; //compile time evaluation as the values of x and y is already known

    cout << z <<END_LINE ;

    return 0 ;
}