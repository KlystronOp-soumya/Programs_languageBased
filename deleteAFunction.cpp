#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] " 
constexpr char END_LINE = '\n' ; 

//we can delete a function

void printInt(int a){
    cout << "a: " << a << END_LINE ;
}

//void printInt(char) = delete; // calls to this function will halt compilation
//void printInt(bool) = delete; // calls to this function will halt compilation

int main(int argc, char* argv[])
{
    printInt(13) ; //no compilation issue
    printInt('a') ; // promoted to 97
    printInt(true) ; // promoted to 1
    // upto this there will not be any issue with the compilation
    // we can also control the execution and tell compiler to fail if the function receives somewhat different argument except int
    // uncomment the above =delete operator line
    return 0 ;
}