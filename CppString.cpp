#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std ;

int main() {
    // 1. Initialize a string
    std::string str = "HelloWorld";

    // 2. Get the length
    std::cout << "Length: " << str.length() << std::endl;

    // 3. Append, Insert, Erase
    str.append("123");
    str.insert(5, "Amazing");
    str.erase(0, 5);
    std::cout << "Modified String: " << str << std::endl;

    // 4. Replace & Extract Substring
    str.replace(3, 4, "Universe");
    std::string sub = str.substr(3, 4);
    cout << "Substring: " << sub << std::endl;

    // 5. Searching for occurrences
    size_t pos = str.find("Universe");
    std::cout << "Position of 'Universe': " << pos << std::endl;

    // 6. Character Manipulation
    char ch = str[0];
    str[0] = 'Z';
    std::cout << "Changed String: " << str << std::endl;

    // 7. String to Number and vice versa
    int num = std::stoi("456");
    std::string numStr = std::to_string(789);
    std::cout << "Converted Num: " << num << ", Converted String: " << numStr << std::endl;

    // 8. Comparing Strings
    std::string str1 = "Hello";
    std::string str2 = "World";
    std::cout << "Comparison Result: " << str1.compare(str2) << std::endl;

    // 9. Sorting a string
    std::sort(str.begin(), str.end());
    std::cout << "Sorted String: " << str << std::endl;

    // 10. Reversing a string
    std::reverse(str.begin(), str.end());
    std::cout << "Reversed String: " << str << std::endl;

    // 11. Counting occurrences
    int count = std::count(str.begin(), str.end(), 'l');
    std::cout << "Occurrences of 'l': " << count << std::endl;

    // 12. Using String Stream to parse numbers
    std::stringstream ss("100 200 300");
    int a, b, c;
    ss >> a >> b >> c;
    std::cout << "Parsed from stream: " << a << ", " << b << ", " << c << std::endl;

    return 0;
}