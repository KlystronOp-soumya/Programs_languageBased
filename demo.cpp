#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
//#include "constants.h"
#include "constinline.h"
// #include <print>
// #include <fmt/core.h>

/*
    Use of constexpr in function
*/
constexpr double calcCircumference(double radius) // now a constexpr function
{
    constexpr double pi { 3.14159265359 };
    return 2.0 * pi * radius;
}

void useConstExpr(){
     constexpr double circumference { calcCircumference(3.0) }; // now compiles -- because we have defined the function with constexpr; had we not done so, we would have never compiled it successfully
     cout<< "Circum of the circle:" << circumference << END_LINE;
}

/*
    type alias
*/

static void typeAliases(){
    using Distance = double; // define Distance as an alias for type double

    Distance milesToDestination{ 3.4 }; // defines a variable of type double

    std::cout << milesToDestination << '\n'; // prints a double value
}

//assertion at compile time
 // static_assert(sizeof(long) >= 8, "long must be 8 bytes");
static_assert(sizeof(int) >= 4, "int must be at least 4 bytes");

void assertion(){
    // #define NDEBUG // disable asserts (must be placed before any #includes)
    bool test = false ;
    assert(!test && "test failed") ;
}


/*
Only use extern for global variable forward declarations or const global variable definitions.
Do not use extern for non-const global variable definitions (they are implicitly extern).
*/

int val = 5 ; 

void useConstantsWithOutInline(){
    /*
    Advantages:

Works prior to C++17.
Only one copy of each variable is required.
Only requires recompilation of one file if the value of a constant changes.
Disadvantages:

Forward declarations and variable definitions are in separate files, and must be kept in sync.
Variables not usable in constant expressions outside of the file in which they are defined.
    
    */
    std::cout << "Enter a radius: ";
    double radius{};
    std::cin >> radius;
    //using namespace constinline ;
    std::cout << "The circumference is: " << 2 * radius * constinline::pi << '\n';
}



void globlaVarShadow(){
     int val = 100 ;
     cout << val++ << " local" << END_LINE;
     ++(::val) ; //avoid variable shadowing and use g_ prefix for globals
     cout << val << "global" << END_LINE ;
}

#include <format>
using namespace std;
constexpr char END_LINE{'\n'};
#define NAME "John"

// A bit mask is a predefined set of bits that is used to select which specific bits will be modified by subsequent operations.
void bitmask()
{
}

void bitWiseBitset()
{
    // Bit-shifting in C++ is endian-agnostic. Left-shift is always towards the most significant bit, and right-shift towards the least significant bit.
    bitset<4> b{0b1100};
    cout << b << END_LINE;
    cout << (b >> 1) << END_LINE; // shift 1 yields 0110
    cout << (b << 1) << END_LINE; // shift left by 1 yields 1000

    std::bitset<4> b4{0b100}; // b4 is 0100
    std::bitset<8> b8{0b100}; // b8 is 0000 0100

    std::cout << "Initial values:\n";
    std::cout << "Bits: " << b4 << ' ' << b8 << '\n';
    std::cout << "Values: " << b4.to_ulong() << ' ' << b8.to_ulong() << "\n\n";

    b4 = ~b4; // flip b4 to 1011
    b8 = ~b8; // flip b8 to 1111 1011

    std::cout << "After bitwise NOT:\n";
    std::cout << "Bits: " << b4 << ' ' << b8 << '\n';
    std::cout << "Values: " << b4.to_ulong() << ' ' << b8.to_ulong() << '\n'; // converts to long
}

void bitsets()
{

    bitset<8> bits{0b000'0101};
    bits.set(3);   // set bit position 3 to 1
    bits.flip(4);  // toggle the bit at position 4 from right idx =1
    bits.reset(4); // sets back to 0

    cout << "All the bits" << bits << END_LINE;
    cout << "Bit has 3 value" << bits.test(3) << END_LINE;
    cout << "Bit 4 has value" << bits.test(4) << END_LINE;

    // better use enums
    [[maybe_unused]] constexpr int isHungry{0};
    [[maybe_unused]] constexpr int isSad{1};
    [[maybe_unused]] constexpr int isMad{2};
    [[maybe_unused]] constexpr int isHappy{3};
    [[maybe_unused]] constexpr int isLaughing{4};
    [[maybe_unused]] constexpr int isAsleep{5};
    [[maybe_unused]] constexpr int isDead{6};
    [[maybe_unused]] constexpr int isCrying{7};

    std::bitset<8> me{0b0000'0101}; // we need 8 bits, start with bit pattern 0000 0101
    me.set(isHappy);                // set bit position 3 to 1 (now we have 0000 1101)
    me.flip(isLaughing);            // flip bit 4 (now we have 0001 1101)
    me.reset(isLaughing);           // set bit 4 back to 0 (now we have 0000 1101)

    std::cout << "All the bits: " << me << '\n';
    std::cout << "I am happy: " << me.test(isHappy) << '\n';
    std::cout << "I am laughing: " << me.test(isLaughing) << '\n';

    // Querying bitset
    std::cout << bits.size() << " bits are in the bitset\n";
    std::cout << bits.count() << " bits are set to true\n";

    std::cout << std::boolalpha;
    std::cout << "All bits are true: " << bits.all() << '\n';
    std::cout << "Some bits are true: " << bits.any() << '\n';
    std::cout << "No bits are true: " << bits.none() << '\n';
}
void printStr(string_view str)
{
    cout << str << END_LINE;
    // get a mutable string
    string st{str}; // ok
    // string st1 = str ; //not ok
    string st2;
    st2 = static_cast<string>(str); // ok
    reverse(st.begin(), st.end());
}

void stringView()
{
    std::string str{"Hello World"}; // is an expensive operation
    // any function call with this str maintains 2 copies of str better use string_view that only passes a read only single copy
    printStr(str);
}

void stringView()
{

    using namespace std::string_literals;      // access the s suffix
    using namespace std::string_view_literals; // access the sv suffix

    std::cout << "foo\n";   // no suffix is a C-style string literal
    std::cout << "goo\n"s;  // s suffix is a std::string literal
    std::cout << "moo\n"sv; // sv suffix is a std::string_view literal

    std::string name{"Alex"};
    std::string_view sv{name}; // sv is now viewing name
    std::cout << sv << '\n';   // prints Alex

    sv = "John";             // sv is now viewing "John" (does not change name)
    std::cout << sv << '\n'; // prints John

    std::cout << name << '\n'; // prints Alex

    constexpr std::string_view s{"Hello, world!"}; // s is a string symbolic constant
    std::cout << s << '\n';                        // s will be replaced with "Hello, world!" at compile-time
}
void strings()
{

    std::cout << "Pick 1 or 2: ";
    int choice{};
    std::cin >> choice;

    std::cout << "Now enter your name: ";
    std::string name{};
    // ws is the input string manipulator that discards any leading space
    std::getline(std::cin >> std::ws, name); // note: added std::ws here

    std::cout << "Hello, " << name << ", you picked " << choice << '\n';

    using namespace std::string_literals; // easy access to the s suffix

    std::cout << "foo\n";  // no suffix is a C-style string literal with Null termination
    std::cout << "goo\n"s; // s suffix is a std::string literal withotu null termination
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