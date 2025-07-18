#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

void printAddress(int* ar, int n) {

    for (int i = 0; i < n; i++)
    {
        printf("ar[%d] : %u \n", i, (ar + i)); //4bytes apart
    }

}

void arrP(int** ar, int n) {

    printf("content at : %u -> %d\n", &ar, *ar);
    printf("content at : %u -> %u\n", &ar, ar);
    for (int i = 0; i < n; i++)
    {   
        printf("%u " ,(ar+i)) ; //while it is adding it is 8Bytes
    }
    


}

int main(int argc, char* argv[])
{
    int n;
    scanf("%d", &n);
    int ar[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &ar[i]);
    }
    printAddress(ar, n);
    arrP(&ar, n);
    ;
    return 0;
}