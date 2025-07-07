//COnverting from vector to a stack
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    vector<int> v(6);
    for (int i = 0; i <= 6; ++i)
    {
        v.push_back(i);
    }
    stack<int> s(deque<int>(v.begin(), v.end()));
    for (int i = 0; i < s.size(); ++i)
    {
        cout << s.top() << " ";
        s.pop();
    }

    stack<int> s1(deque<int>(v.begin(), v.end())); //v.end(),v.begin() not accepted
    for (int i = 0; i < s1.size(); ++i)
    {
        cout << s1.top() << " ";
        s1.pop();
    }
    return 0;
}
