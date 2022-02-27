#include<stdio.h>

int main(int argc, char const *argv[])
{
    /* code */
    //type declaration demo
    int i;
    int j;

    printf("%u\n",&i); //prints the address
    printf("%d\n",sizeof(i));//4bytes
    
    i=10;
     printf("%d",i);
    j=12;

    int m,n;
    m=10,n=12;

    int p=10,q=12;
    q=13;

    
    int a=4;
    int b=a*4;

    char ch = 'A';
    printf("%c is the character and %d is the ASCII",ch,ch);

    int cha='a';//type conversion implicit
    printf("%d",cha);
    printf("%c",cha);
    return 0;
}
