/*Simple program to store the key value pair */
#include<stdio.h>
#include<stdlib.h>

typedef struct PAIR{
    int first ;
    int second ;
} pair ;

//define the function signatures
void make_pair(int a , int b) ;
void display_pair(pair *pair) ;

int main(int argc , char* argv[])
{
    make_pair(5,2) ;
    make_pair(3,5) ;
    return 0;
}

void make_pair(int first , int second)
{
    printf("Called") ;
    //dynamically allocate
    pair* pair_ptr = NULL;
    pair_ptr = (pair*) malloc(sizeof(pair) * 1) ;

    pair** pair_ref = NULL ;
   
    pair_ref = &pair_ptr ;

    (*pair_ref)->first = first ;
    (*pair_ref)->second = second ;

    printf("log:: pair created: <%d, %d>\n" ,(*pair_ref)->first ,  (*pair_ref)->second ) ;
    printf("log:: pair created: <%d, %d>\n" , (**pair_ref).first , (**pair_ref).second) ;
    free(*pair_ref) ;
    //free(pair_ptr) ;

   
}