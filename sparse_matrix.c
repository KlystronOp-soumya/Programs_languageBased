#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
#define MAX1 3
#define MAX2 3

typedef struct sparse_matrix
{
    int *sp;
    int row;
}Sparse;
 
 void init (Sparse *sprs_ptr);
 void init_array(Sparse *sprs_ptr) ;
 void disp(Sparse sp_obj);
 int count(Sparse sp_obj);
 void create_tuple(Sparse *sp_obj2,Sparse *sp_obj1);
 void disp_tuple(Sparse sp_obj);
 void dealloc(Sparse *sprs_ptr);


int main(int argc,char*argv[])
{
 //declaration
 Sparse sp_obj1,sp_obj2;

 init(&sp_obj1);//sparse matrix
 init(&sp_obj2);//3-tuple form

 init_array(&sp_obj1);//initializing the sparse array
 printf("elements in the Sparse Matrix: ");
 disp(sp_obj1);

 int c = count(sp_obj1) ;

 printf("Number of non-zero elements: %d\n\n",c);
  create_tuple(&sp_obj2,&sp_obj1);
  printf("Array of non-zero elements:");
 disp_tuple(sp_obj2) ;//display 3-tuple form

//freeing the memory
 dealloc(&sp_obj1);
 dealloc(&sp_obj2);

return 0;
}
void init (Sparse *sprs_ptr)
{
    sprs_ptr->sp = NULL;
}

void init_array(Sparse *sprs_ptr) 
{
    int n,i ;
    sprs_ptr->sp = (int *) malloc(sizeof(int)*MAX1*MAX2);

    for(i =0 ;i<MAX1*MAX2;i++)
    {
        printf("Enter element no.%d: ",i);
        scanf("%d",&n);
       *(sprs_ptr->sp+i) = n ;
    }
    printf("\n\n");
}

 void disp(Sparse sp_obj)
 {
    for(int i =0;i<MAX1*MAX2;i++)
    {
        if(i%MAX2 == 0)
        printf("\n");
    
    printf("%d\t",sp_obj.sp[i]) ;
    }
 }
int count(Sparse p)
{
    int c = 0;
    for(int i =0;i<= MAX1*MAX2;i++)
    {
        if (*(p.sp +i) != 0)
        {
            c++;
        }
    }
    return c ;
}

void create_tuple(Sparse *p, Sparse *s)
{
    int r =0,c=-1,l=-1,i;
    p->row = count(*s)+1 ;

    p->sp= (int *) malloc(p->row*3*sizeof(int));
    *(p->sp + 0) = MAX1;
    *(p->sp+1) = MAX2 ;
    *(p->sp+2)=p->row -1 ;

    l=2;
    for(i =0 ; i<=MAX1 * MAX2 ;i++)
    {
        c++;
        //sets the row and column
        if(((i%MAX2) == 0)&& (i!=0))
        {
            r++;//tuple breakdown
            c=0;//reset
        }
        //checks the non zero values
        if(*(s->sp+i)!=0)
        {
            l++;//3
            *(p->sp+l) =r ;
            l++;//4
            *(p->sp+l) =c ;
            l++;//5
            *(p->sp+l) =*(s->sp+i) ;
        }

    }
}
void disp_tuple(Sparse sp_obj)
{
    for(int i =0;i<sp_obj.row*3;i++)
    {
        if(i%3 ==0 )
         printf("\n");
        printf("%d\t",(sp_obj.sp[i]));
    }
}
 void dealloc(Sparse *sprs_ptr)
 {
    free(sprs_ptr->sp) ;
 }