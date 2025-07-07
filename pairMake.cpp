#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE \n 


int main(int argc, char* argv[])
{

    // Create a pair of an integer and a string
    std::pair<int, std::string> myPair = std::make_pair(42, "Hello, World!");

    // Access the elements
    int myInt = myPair.first;
    std::string myString = myPair.second;

    // Print the values
    std::cout << "Integer: " << myInt << std::endl;
    std::cout << "String: " << myString << std::endl;

return 0 ;
}