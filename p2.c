#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void sort(int *ar,int n)
{
     for (int c = 0 ; c < n - 1; c++)
  {
    for (int d = 0 ; d < n - c - 1; d++)
    {
      if (ar[d] > ar[d+1]) /* For decreasing order use '<' instead of '>' */
      {
       int  swap       = ar[d];
        ar[d]   = ar[d+1];
        ar[d+1] = swap;
      }
    }
  }
}


void solve(int *ar,int n)
{
  int freq[10];//init
  memset(freq,0,sizeof(int)*10);
 /*  for(int i=0;i<10;++i)
  {printf("%d ",freq[i]);
  } */
  for(int i=0;i<n;++i)
  {
      int rem_index=ar[i]%10;
      //printf("rem:%d\n",rem_index);
      freq[rem_index]+=1;

  }
  for(int i=0;i<10;++i)
  {
      if(freq[i]==1)
      {
          printf("%d",ar[i]);
          break;
      }
  }
  
    return;
}

int main(int argc, char const *argv[])
{
    /* code */
    int n;
    scanf("%d",&n);
   int *ar=malloc(sizeof(int)*n);
    for(int i=0;i<n;++i)
    {
      scanf("%d",&ar[i]);

    }
    sort(ar,n);

    solve(ar,n);
    return 0;
}
