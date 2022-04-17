#include<bits/stdc++.h>
using namespace std;
void gap()
{
    cout<<"\n";
}
int main(int argc, char const *argv[])
{
    int n;
    cin>>n;
    //initialization
    vector<int>v1;
    vector<int>v2{n,true};//a;; with 1
    vector<int>v3{1,2,3,4,5,6};

    //insert values
    for(int i=11;i<=15;++i)
    v1.push_back(i);


    //getting sizes
    int s1=v1.size();
    int s2=v2.size();
    int s3=v3.size();
    cout<<s1<<" "<<s2<<" "<<s3<<endl;

    for(int i=0;i<s1;++i)
    cout<<v1[i];
    gap();
    
    //using iterator
    gap();
    
    //get and pop
    gap();
    //swap
    gap();
    //sort
    gap();
    //for each
    gap();
    return 0;
    //find and distance
}
