#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    stringstream ss ;
    int number = 42 ;
    double pi = 3.1415926535;

    ss<<number ;

    string strNum ;
    ss>>strNum ;

    cout<< "Type of pi:" << typeid(pi).name()<<endl ;

    cout<< strNum << endl;

    //reset a StringStream
    ss.str("") ;
    ss.clear() ;

    // **Parsing Multiple Values**
    std::string input = "123 456 789";
    ss << input;

    int a, b, c;
    ss >> a >> b >> c; // Extract integers from the stream

    std::cout << "Extracted values: " << a << ", " << b << ", " << c << std::endl;

    // **Advanced Usage** - Formatting Output
    
    ss.str(""); 
    ss.clear();

    ss.precision(4); // Set precision to 4 decimal places
    ss << std::fixed << pi; // Format and store

    std::string formattedPi;
    ss >> formattedPi;
    std::cout << "Formatted Pi value: " << formattedPi << std::endl;


// **Using StringStream for File-Like Input**
    std::string data = "Name: Alice Age: 25";
    ss.str(data);
    ss.clear();

    std::string label1, label2, name;
    int age;
    
    ss >> label1 >> name >> label2 >> age;
    std::cout << "Extracted from stream - Name: " << name << ", Age: " << age << endl ;

  

    return 0 ;
}