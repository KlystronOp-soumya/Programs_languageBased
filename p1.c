#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100


void solve(char* st)
{
    register int xor_res=st[0];
    //cout<<"Curent:"<<xor_res;
    for(int i=1;i<strlen(st);++i)
    {
        int temp=st[i];
        xor_res^=temp;
       // cout<<"xor:"<<xor_res<<endl;
       // cout<<"ASCII: "<<temp<<"of :"<<st[i]<<endl;
    }
    printf("%d",xor_res);

}

int main(int argc, char const *argv[])
{
    /* code */
    char *st;
    st=(char*)malloc(sizeof(char)*MAX);
    fflush(stdin);
    gets(st);
    solve(st);
    return 0;
}
