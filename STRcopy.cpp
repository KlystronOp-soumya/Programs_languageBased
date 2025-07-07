// string::copy
#include <iostream>
#include <string>
using namespace std;

int main()
{
    char buffer[20];
    std::string str("Test string...");
    std::size_t length = str.copy(buffer, 6, 5); //dest,length,pos
    buffer[length] = '\0';

    /* string s = "";
    length = str.copy(s, 6, 5); Not valid*/

    std::cout << "buffer contains: " << buffer << '\n';
    return 0;
}