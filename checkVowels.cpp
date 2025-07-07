#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 

#include <unordered_set>

bool isVowel(char c) {
    static const std::unordered_set<char> vowels = {'a', 'o', 'y', 'e', 'u', 'i'};
    return vowels.count(tolower(c));
}

bool isVowel(char c) {
    c = tolower(c);
    static  bool vowelMap[128] = {0}; // Initialize all to false
    static bool initialized = false;

    if (!initialized) {
        for (char v : "aoyeui") {
            vowelMap[v] = true;
        initialized = true;
    }
    }
    return vowelMap[c];
}
int main(int argc, char* argv[])
{
    

    return 0 ;
}