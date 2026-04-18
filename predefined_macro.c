#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 


int main(int argc, char* argv[])
{

    printf("This is line %d in file %s\n", __LINE__, __FILE__);
    printf("Compiled on %s at %s\n", __DATE__, __TIME__);

    return 0;
}