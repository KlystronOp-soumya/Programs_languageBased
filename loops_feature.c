#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    /* code */
    int i=0,j;
    int num = 100 ;

    while(i++<=num)//i++ or ++i
    {
      //instruction
      printf("%d\n",i);
     // i++; //i+=1.i=i+1
    }
    i=0;//reset
    printf("Inside 3rd loop\n");
    while(++i<=100)
    {
        printf("%d\n",i);
    }
    return 0;
}
