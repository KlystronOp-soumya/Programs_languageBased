#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    /* code */
    /* for i in range(1,6):
     for j in range(1,11):
      print(i*j) */
    
    for (int i = 1; i < 6; i++)//i=1
    {
        for (int j = 1; j < 11; j++)
        {
            /* code */
            printf("%d*%d = %d\n",i,j,i*j);
        }
        printf("\n");
        
    }
    
    return 0;
}
