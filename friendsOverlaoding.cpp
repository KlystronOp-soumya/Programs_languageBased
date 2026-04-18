#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 

const int8_t size = 3 ;

class vector{

    int v[size] ;
    public:
        vector(){} ;
        vector(int *x) ;
        friend vector operator *(int a, vector b) ;

} ;

int main(int argc, char* argv[])
{
     

    return 0 ;
}