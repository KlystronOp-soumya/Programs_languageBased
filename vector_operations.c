#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
 typedef struct _vector_components
 {
      double i_cap;
      double j_cap;
      double k_cap ;

 }VECTOR ;
 
 //method sigantures
VECTOR position_vector(VECTOR *a, VECTOR *b) ;

void show_vector(VECTOR a);
int main(int argc,char*argv[])
{
 //definition
 VECTOR a,b ;

 printf("Enter the components of the vector a :\n") ;
 scanf("%ld%ld%ld",&a.i_cap,&a.j_cap,&a.k_cap) ;
 printf("Enter the components of the vector b :\n") ;
 scanf("%ld%ld%ld",&b.i_cap,&b.j_cap,&b.k_cap) ;

 VECTOR c = position_vector(&a, &b) ;
 show_vector(c) ;
return 0;
}

VECTOR position_vector(VECTOR *a,VECTOR *b)
{
    VECTOR c ;

    c.i_cap = (a->i_cap) - (b->i_cap) ;
    c.j_cap = (a->j_cap )- (b->j_cap) ;
    c.k_cap = (a->k_cap) - (b->k_cap) ;

    return c ;
} 

void show_vector(VECTOR a)
{
    printf("x: %ld \n",a.i_cap) ;
    printf("y: %ld \n",a.j_cap) ;
    printf("z: %ld \n",a.k_cap) ;

}