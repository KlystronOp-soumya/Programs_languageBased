#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    // Create a random number generator with the Mersenne Twister engine
    std::random_device rd;  // Seed generator
    std::mt19937 mt(rd());  // Mersenne Twister PRNG seeded with a random value

    // Define a range for random numbers
    std::uniform_int_distribution<int> dist(1, 100); // Generates numbers between 1 and 100

    // Generate and print 10 random numbers
    std::cout << "Random numbers using Mersenne Twister:\n";
    for (int i = 0; i < 10; ++i) {
        std::cout << dist(mt) << " ";
    }
    std::cout << std::endl;

    return 0;


    return 0 ;
}