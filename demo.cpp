#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n'
#define NAME "John"

void casting(){
    double d { 5 }; // okay: int to double is safe
    int x { 5.5 }; // error: double to int not safe
    x= static_cast<int>(5.5) ;
    cout << x ;
}

void chars(){
    /*You won’t need to use char8_t, char16_t, or char32_t unless you’re planning on making your program Unicode compatible. wchar_t should be avoided in almost all cases (except when interfacing with the Windows API), as its size is implementation-defined.*/
    char ch{} ;
    cin.get(ch) ;
    cout<< ch << END_LINE ;
}

void floatsAndDoubles(){

    std::cout << std::boolalpha; // print bool as true or false rather than 1 or 0
    std::cout << "float: " << std::numeric_limits<float>::is_iec559 << '\n';
    std::cout << "double: " << std::numeric_limits<double>::is_iec559 << '\n';
    std::cout << "long double: " << std::numeric_limits<long double>::is_iec559 << '\n';

    //as floats are not as precise as double there is always a possibility of information loss
    std::cout << std::setprecision(17); // show 17 digits of precision
    std::cout << 3.33333333333333333333333333333333333333f <<'\n'; // f suffix means float are less precise and double
    std::cout << 3.33333333333333333333333333333333333333 << '\n'; // no suffix means double
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
    //abort() ; //std:;abort
    //terminate(); //std::terminate
    #if defined NAME
     cout<< "Name" << NAME ;
    #endif
    #if !defined NAME
        cout<<"macro was not defined"
    #endif
    return 0;
}