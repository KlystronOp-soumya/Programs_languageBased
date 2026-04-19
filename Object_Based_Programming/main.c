#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<windows.h>
#include "coordinates.h"
#include<stddef.h>

#define MAX_ELEM 100 

#define END_LINE '\n' 


int main(int argc, char* argv[])
{
    /*Create and initialize the pointers to coordinate objects */
    coordinate *c1 = coordinate_create() ;
    coordinate *c2 = coordinate_create() ;

    c1->setx(c1 , 1) ;
    c1->sety(c1 , 2) ;

    
    c2->setx(c2 , 1) ;
    c2->sety(c2 , 2) ;

    c1->print(c1) ;
    c1->print(c2) ;

    coordinate_destroy(c1) ;
    coordinate_destroy(c2) ;

    c1= NULL ;
    c2 = NULL ;

    return 0 ;
}