#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
#define BREAK_LINE printf("\n\n") ;
#define MAX 10

typedef struct TERM
{
    int coeff ;
    int exp ;
}Term;

typedef struct POLY
{
  Term term_arr [10];
  int no_of_terms ;
}Polynom;
 
 //signatures
 void initpoly(Polynom * a);
 void polyappend(Polynom *a,int c,int e);
 Polynom polyadd(Polynom a, Polynom b) ;
 void display(Polynom a) ;
int max_term_poly(Polynom a , Polynom b);
int main(int argc,char*argv[])
{
 
 Polynom p1,p2,p3 ;

 initpoly(&p1);
 initpoly(&p2);

 polyappend(&p1,1,7) ;
 polyappend(&p1,2,6) ;
 polyappend(&p1,3,5) ;
 polyappend(&p1,4,4) ;
 polyappend(&p1,5,2) ;

 polyappend(&p2,1,4) ;
 polyappend(&p2,1,3) ;
 polyappend(&p2,1,2) ;
 polyappend(&p2,1,1) ;
 polyappend(&p2,2,0) ;

 p3=polyadd(p1,p2) ;

 printf("First polynomial:\n") ;
 display(p1) ;
 BREAK_LINE;
 printf("Second polynomial:\n");
 display(p2);
  BREAK_LINE;
 printf("After addition:\n");
 display(p3);


return 0;
}

void initpoly(Polynom *p)
{
  p->no_of_terms=0;

  for(int i =0;i<MAX ;i++)
  {
    p->term_arr[i].coeff=0;
     p->term_arr[i].exp=0;
  }
}
 void polyappend(Polynom *p,int c,int e)
 {
   p->term_arr[p->no_of_terms].coeff = c ;
   p->term_arr[p->no_of_terms].exp = e;

   p->no_of_terms++ ; //increasing the term counter
 }

 void display(Polynom p)
 {
  int flag=0;
   for(int i = 0;i<=p.no_of_terms ;i++)
   {
    if(p.term_arr[i].exp != 0)
    {
      printf("%dX^%d+",p.term_arr[i].coeff,p.term_arr[i].exp) ;
    }
    else
    {
      printf("%d",p.term_arr[i].coeff) ;
      flag=1;
    }
    
   }
   if(!flag)
   {
     printf("\b\b");
   }
 }

 int max_term_poly(Polynom a , Polynom b)
 {
   return (a.no_of_terms > b.no_of_terms)? a.no_of_terms : b.no_of_terms ;
 }

 Polynom polyadd(Polynom a, Polynom b)
 {
    int poly1_term_counter=0 , poly2_term_counter=0 ;
    int max_len = max_term_poly(a,b) ;
    //define a new struct
    Polynom c; //static
    //initialize the polynom
    initpoly(&c) ;

    for(poly1_term_counter=0,poly2_term_counter=0 ; poly1_term_counter <= max_len ; c.no_of_terms++)
    {
      //end of polynomial
      if(a.term_arr[poly1_term_counter].coeff= 0 && b.term_arr[poly2_term_counter].coeff == 0)
        break;
      if(a.term_arr[poly1_term_counter].exp >= b.term_arr[poly2_term_counter].exp)
      {
        //terms with same exponent will be added
        if(a.term_arr[poly1_term_counter].exp == b.term_arr[poly2_term_counter].exp)
        {
          c.term_arr[c.no_of_terms].coeff = a.term_arr[poly1_term_counter].coeff + b.term_arr[poly2_term_counter].coeff;
        c.term_arr[c.no_of_terms].exp = a.term_arr[poly1_term_counter].exp ;
        poly1_term_counter++;
        poly2_term_counter++;
        }
        else //otherwise will be copied simply and moved to next term
        {
          c.term_arr[c.no_of_terms].coeff = a.term_arr[poly1_term_counter].coeff;
          c.term_arr[c.no_of_terms].exp = a.term_arr[poly1_term_counter].exp ;
          poly1_term_counter++;
        }
      }
       else // if second polynomial greater degree of terms
    {
       c.term_arr[c.no_of_terms].coeff =  b.term_arr[poly2_term_counter].coeff;
        c.term_arr[c.no_of_terms].exp =  b.term_arr[poly2_term_counter].exp ;
        poly2_term_counter++;
    }
    }
   
    return c;
 }

