#pragma GCC optimize("Ofast")
#include <bits/stdc++.h>
using namespace std;

#define forn(i, n) for (int i = 0; i < int(n); ++i)
#define for1(i, n) for (int i = 1; i <= int(n); ++i)
#define ford(i, n) for (int i = int(n) - 1; i >= 0; --i)
#define fore(i, l, r) for (int i = int(l); i < int(r); ++i)
#define forit(itr, v) for (typeof((v).begin()) itr = (v).begin(); itr != (v).end(); ++itr)
#define sz(v) int((v).size())
#define all(v) (v).begin(), (v).end()
#define pb push_back
#define X first
#define Y second
#define mp make_pair
template <typename T>
inline T abs(T a)
{
  return ((a < 0) ? -a : a);
}
template <typename T>
inline T sqr(T a) { return a * a; }

typedef long long li;
typedef long double ld;
typedef pair<int, int> pt;

const int INF = (int)1E9 + 7;
const ld EPS = 1E-9;
const ld PI = 3.1415926535897932384626433832795;

/* void solve()
{
} */
/* void test_cases(int t)
{
  while (t--)
  {
    solve();
  }
} */

int main()
{
  // auto start = chrono::high_resolution_clock::now();
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
#ifdef myproject
  freopen("input.txt", "rt", stdin);
//freopen("output.txt", "wt", stdout);
#endif

  /*
   int t;
   scanf("%d",&t);
   test_cases(t);
  */

  /* auto end = chrono::high_resolution_clock::now(); 
    // Calculating total time taken by the program. 
    double time_taken =  
      chrono::duration_cast<chrono::nanoseconds>(end - start).count(); 
  
    time_taken *= 1e-9; 
  
    cout << "Time taken by program is : " << fixed  
         << time_taken << setprecision(9); 
    cout << " sec" << endl;*/

  return 0;
}