#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

/*
Get the Assembly code:  gcc -S .\test.c -fverbose-asm -Os -o - > sourceASM.txt
 gcc -fno-asynchronous-unwind-tables -fno-exceptions  -fverbose-asm -Wall -Wextra .\test.c 
-O3 -masm=intel -S -o- > mysource.txt

Follow thread- https://stackoverflow.com/questions/137038/how-do-you-get-assembler-output-from-c-c-source-in-gcc

*/

int main(int argc, char* argv[])
{
    printf("Hello World") ;
    int x , y ;
    char *str = malloc(11*sizeof(char)) ;
    printf(END_LINE) ;
    scanf("%d%d" , &x, &y) ; 
    int sum = x+y ;
    printf("%d" , sum) ;
    fflush(stdin) ;
    fgets(str , 10 , stdin) ;    
  
    printf(">>> %s" , str) ;

    free(str); 
    return 0 ;
}
