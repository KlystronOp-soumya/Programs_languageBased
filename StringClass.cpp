#include <bits/stdc++.h>
using namespace std;

//all the string class functions

int main(int argc, char const *argv[])
{
    //String constructor
    string s1, s2;
    char s[] = "Hello world";
    s1 = string(s);
    cout << "Converted from C string to cpp STirng class: " << s1 << endl;
    s2 = "This is cpp";
    cout << "CPP string class object:" << s2 << endl;
    //diffrent functions in cpp
    cout << "The length of the string(length):" << s1.length() << endl;
    cout << "The length of the string (size):" << s1.size() << endl;
    //take user input
    string s3;
    cout << "Enter a string: " << endl;
    getline(cin, s3);
    cout << s3 << endl;
    //another way to take the input
    char nm[50];
    cin.getline(nm, 50);
    cout << nm << endl;
    //swap the contents of two strings
    string name, title;
    cout << "Enter name and title: " << endl;
    getline(cin, name);
    getline(cin, title);
    cout << "Before Swapping name and title is: " << name << title << endl;
    swap(name, title);
    cout << "After swapping name and title is:" << name << title << endl;
    //concatenation
    cout << "concatenating name and title->";
    string s4 = name + title;
    cout << s4 << endl;
    //compare 2 strings
    std::string str1("green apple");
    std::string str2("red apple");

    if (str1.compare(str2) != 0)
        std::cout << str1 << " is not " << str2 << '\n';

    if (str1.compare(6, 5, "apple") == 0) //startign index and length
        std::cout << "still, " << str1 << " is an apple\n";

    if (str2.compare(str2.size() - 5, 5, "apple") == 0)
        std::cout << "and " << str2 << " is also an apple\n";

    if (str1.compare(6, 5, str2, 4, 5) == 0)
        std::cout << "therefore, both are apples\n";

    //SUBSTRING
    /* std::string str = "We think in generalities, but we live in details.";
    // (quoting Alfred N. Whitehead)

    std::string str2 = str.substr(3, 5); // "think"

    std::size_t pos = str.find("live"); // position of "live" in str

    std::string str3 = str.substr(pos); // get from "live" to the end

    std::cout << str2 << ' ' << str3 << '\n'; */

    //find_first_of=first occurence of a string
    /* std::string str("Please, replace the vowels in this sentence by asterisks.");
    std::size_t found = str.find_first_of("aeiou");
    cout << "Found at: " << found;
    while (found != std::string::npos) //npos=-1 is constant member
    {
        str[found] = '*';
        found = str.find_first_of("aeiou", found + 1); //now found was 2;now 2+1=3(search continues from there)
    }

    std::cout << str << '\n'; */

    

    return 0;
}
