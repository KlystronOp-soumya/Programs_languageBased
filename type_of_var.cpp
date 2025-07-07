#include <iostream>
#include <typeinfo>

int main() {
    int myInt = 42;
    double myDouble = 3.14;
    std::string myString = "Hello, World!";

    std::cout << "Type of myInt: " << typeid(myInt).name() << std::endl;
    std::cout << "Type of myDouble: " << typeid(myDouble).name() << std::endl;
    std::cout << "Type of myString: " << typeid(myString).name() << std::endl;

    return 0;
}
