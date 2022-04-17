#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    stack<int> st;
    for (int i = 0; i < n; ++i)
    {
        int choice;
        cin >> choice;
        if (choice == 1)
        {
            int t;
            cin >> t;
            if (st.empty())
            {
                st.push(t);
            }
            else
            {
                st.push(max(t, st.top()));
            }
            //cout << "current:" << st.top();
        }
        if (choice == 2)
        {
            // cout << "popped:" << st.top() << '\n';
            st.pop();
        }
        if (choice == 3)
        {
            cout << st.top()<<'\n';
        }
    }
    return 0;
}
