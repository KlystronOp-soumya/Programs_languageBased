//Hacker rank Stack problem
#include<bits/stdc++.h>

using namespace std;
int top=-1;
void push(int * st)
{
    int n;
    cin>>n;
    st[++top]=n;
    cout<<"top="<<top<<endl;
}
void pop(int *st)
{
   int val=st[top--];
   cout<<"Pop element:"<<val<<endl;
}
void peek(int * st)
{
   cout<<"Peek element:"<<st[top]<<endl;
}
void max(int * st)
{
    int max=0;
    for(int i=top;i>=0;--i)
    {
        if(max<st[i])
         max=st[i];
    }
    cout<<"max:"<<max<<endl;
}
void show(int * st)
{
     
    for(int i=top;i>=0;--i)
    cout<<st[i]<<endl;
}


int main(int argc, char const *argv[])
{
    int *st,n,choice;
    cout<<"Enter the size of the st"<<endl;
    cin>>n;
    st = new int[n];
    cout<<"Enter your choice:"<<endl;
    do
    {
      cout<<"1.Push 2.Pop 3.show 4.Peek 5.Max"<<endl;
      cin>>choice;

      switch (choice)
      {
      case 1:
            push(st);
          break;
      case 2:
            pop(st);
          break;
      case 3:
            show(st);
          break;
      case 4:
            peek(st);
          break;
      case 5:
             max(st);
      default:
          cout<<"No Opt"; 
            
     }
    }while(choice<6);  
    delete[] st;
    return 0;
}
