#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE \n 


int main(int argc, char* argv[])
{
    char mystr[21] = "This is my string";
    
    cout << mystr <<"length is:" << strlen(mystr) ;
    const char *ss = "ss " ;
    strcat(mystr , ss) ;

    cout << mystr <<"length is:" << strlen(mystr) ;

    string s = mystr ;

   cout << s ;

return 0 ;
}