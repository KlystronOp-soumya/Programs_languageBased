#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] " 
constexpr char END_LINE = '\n' ; 

static void log(string_view level = "[INFO]", string_view message="executed" ){
    cout << level << " " << message << END_LINE ;
 }

int main(int argc, char* argv[])
{
    //If a parameter is given a default argument, all subsequent parameters (to the right) must also be given default arguments.
    // you will get error: default argument missing for parameter 2 of 'void log(std::string_view, std::string_view)'
    // like python we can define default args in CPP also
    log() ;// [INFO] executed
    log("[debug]","This was debug" ) ; // like python the default values will be replaced
    return 0 ;
}