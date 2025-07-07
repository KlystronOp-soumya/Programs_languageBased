#include <iostream>
#include <sstream>
#include <string>
using namespace std ;
int main() {
    std::string input, word;
    std::cout << "Enter a sentence: ";
    std::getline(std::cin, input);

    std::stringstream ss(input); // Convert string to stream
    while (ss >> word) { // Extract each word
        std::cout << "Word: " << word << std::endl;
    }
    return 0;
}