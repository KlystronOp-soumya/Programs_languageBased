#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    std::string cppString = "Hello, C-style string!";
    
    // Convert to C-style string
    const char* cString = cppString.c_str();

    std::cout << "C++ String: " << cppString << std::endl;
    std::cout << "C-style String: " << cString << std::endl;


    return 0 ;
}