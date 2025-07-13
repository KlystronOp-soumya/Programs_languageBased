#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
// #include <print>
// #include <fmt/core.h>

#include <format>
using namespace std;
#define END_LINE '\n'
#define NAME "John"

void strings()
{

    std::cout << "Pick 1 or 2: ";
    int choice{};
    std::cin >> choice;

    std::cout << "Now enter your name: ";
    std::string name{};
    //ws is the input string manipulator that discards any leading space
    std::getline(std::cin >> std::ws, name); // note: added std::ws here

    std::cout << "Hello, " << name << ", you picked " << choice << '\n';

     using namespace std::string_literals; // easy access to the s suffix

    std::cout << "foo\n";   // no suffix is a C-style string literal with Null termination
    std::cout << "goo\n"s;  // s suffix is a std::string literal withotu null termination
    /*
    constexpr std::string name{ "Alex"s }; // compile error
    */
 
}

void literals()
{
    double avogadro{6.02e23};     // 6.02 x 10^23 is a double literal in scientific notation
    double protonCharge{1.6e-19}; // charge on a proton is 1.6 x 10^-19

    // binary literals
    int16_t bin{};
    bin = 0x0001; // assign binary 0000 0000 0000 0001 to the variable
    bin = 0x0002; // assign binary 0000 0000 0000 0010 to the variable
    bin = 0x0004; // assign binary 0000 0000 0000 0100 to the variable
    bin = 0x0008; // assign binary 0000 0000 0000 1000 to the variable
    bin = 0x0010; // assign binary 0000 0000 0001 0000 to the variable
    bin = 0x0020; // assign binary 0000 0000 0010 0000 to the variable
    bin = 0x0040; // assign binary 0000 0000 0100 0000 to the variable
    bin = 0x0080; // assign binary 0000 0000 1000 0000 to the variable
    bin = 0x00FF; // assign binary 0000 0000 1111 1111 to the variable
    bin = 0x00B3; // assign binary 0000 0000 1011 0011 to the variable
    bin = 0xF770; // assign binary 1111 0111 0111 0000 to the variable

    int bin2{};        // assume 16-bit ints
    bin2 = 0b1;        // assign binary 0000 0000 0000 0001 to the variable
    bin2 = 0b11;       // assign binary 0000 0000 0000 0011 to the variable
    bin2 = 0b1010;     // assign binary 0000 0000 0000 1010 to the variable
    bin2 = 0b11110000; // assign binary 0000 0000 1111 0000 to the variable

    int bin3{0b1011'0010};     // assign binary 1011 0010 to the variable
    long value{2'132'673'462}; // much easier to read than 2132673462 in java _
    int x{12};
    std::cout << x << '\n';             // decimal (by default)
    std::cout << std::hex << x << '\n'; // hexadecimal
    std::cout << x << '\n';             // now hexadecimal
    std::cout << std::oct << x << '\n'; // octal
    std::cout << std::dec << x << '\n'; // return to decimal
    std::cout << x << '\n';             // decimal

    // std::bitset<8> means we want to store 8 bits
    std::bitset<8> bin11{0b1100'0101}; // binary literal for binary 1100 0101
    std::bitset<8> bin21{0xC5};        // hexadecimal literal for binary 1100 0101

    std::cout << bin11 << '\n'
              << bin21 << '\n';
    std::cout << std::bitset<4>{0b1010} << '\n'; // create a temporary std::bitset and print it

    // in c++20
    std::cout << std::format("{:b}\n", 0b1010);  // C++20, {:b} formats the argument as binary digits
    std::cout << std::format("{:#b}\n", 0b1010); // C++20, {:#b} formats the argument as 0b-prefixed binary digits

    // std::println("{:b} {:#b}", 0b1010, 0b1010);  // C++23, format/print two arguments (same as above) and a newline
}

void constants()
{

    const double gforce{9.8};
    cout << gforce << END_LINE;
    int x = 5;
    const int constX{x};
    cout << "x:" << x << END_LINE;
    x = 13;
    cout << "x:" << x << END_LINE;
    cout << "constX:" << constX << END_LINE;
    // x can not be used as x is not a const val
    const int y = 13;
    // func args can be const but not constexpr
    constexpr int exprx{y}; // Because variable x is constexpr, expr must be evaluatable at compile-time
}

void casting()
{
    double d{5}; // okay: int to double is safe
    // int x{5.5};  // error: double to int not safe
    int y = static_cast<int>(5.5);
    cout << y;
}

void chars()
{
    /*You won’t need to use char8_t, char16_t, or char32_t unless you’re planning on making your program Unicode compatible. wchar_t should be avoided in almost all cases (except when interfacing with the Windows API), as its size is implementation-defined.*/
    char ch{};
    cin.get(ch);
    cout << ch << END_LINE;
}

void floatsAndDoubles()
{

    std::cout << std::boolalpha; // print bool as true or false rather than 1 or 0
    std::cout << "float: " << std::numeric_limits<float>::is_iec559 << '\n';
    std::cout << "double: " << std::numeric_limits<double>::is_iec559 << '\n';
    std::cout << "long double: " << std::numeric_limits<long double>::is_iec559 << '\n';

    // as floats are not as precise as double there is always a possibility of information loss
    std::cout << std::setprecision(17);                             // show 17 digits of precision
    std::cout << 3.33333333333333333333333333333333333333f << '\n'; // f suffix means float are less precise and double
    std::cout << 3.33333333333333333333333333333333333333 << '\n';  // no suffix means double
}

int main(int argc, char *argv[])
{
    // initialization
    int a = 5, b = 6;              // copy-initialization
    int c(7), d(8);                // direct-initialization
    int e{9}, f{10};               // direct-list-initialization
    [[maybe_unused]] int i{}, j{}; // value-initialization
    string s{"Hello World"};
    // this is a feature of the c++17
    [[maybe_unused]] double pi{3.14159};  // Don't complain if pi is unused
    [[maybe_unused]] double gravity{9.8}; // Don't complain if gravity is unused
    [[maybe_unused]] double phi{1.61803}; // Don't complain if phi is unused

    std::cout << pi << '\n';
    std::cout << phi << '\n';

// The compiler will no longer warn about gravity not being used
// abort() ; //std:;abort
// terminate(); //std::terminate
#if defined NAME
    cout << "Name" << NAME;
#endif
#if !defined NAME
    cout << "macro was not defined"
#endif
        return 0;
}