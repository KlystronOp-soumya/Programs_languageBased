/* Program shows different methods to initiate 2D array in C*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

/*void matrix_add(int **mat1 , int **mat2 , int r, int c )
{
    
}*/
 
void display(int (*mat)[3] , int r , int c)
{
    for(int i = 0 ; i< r ; i++)
    {
        for(int j = 0 ; j< c ; j++)
        {
            //printf("%d" , *( *(mat + i) + j) ) ; //possible
            //printf("%d " , mat[i][j]) ; //possible
            printf("%d" , (((*mat)[i])+j)) ; //possible
        }
        printf("\n") ;
    }
    printf("\n\n") ;
}
void display3(int (*mat)[3][3] , int r , int c) //possible
{
    for(int i = 0 ; i< r ; i++)
    {
        for(int j = 0 ; j< c ; j++)
        { 
            printf("%d" , (*mat)[i][j]) ; //possbile
        }
        printf("\n") ;
    }
    printf("\n\n") ;
}
void display2(int **mat , int r , int c)
{
    for(int i = 0 ; i< r ; i++)
    {
        for(int j = 0 ; j< c ; j++)
        {
            //printf("%d" , *( *(mat + i) + j) ) ;
            //printf("%d " , mat[i][j]) ;
            printf("%d " , *( *(mat + i) + j) ) ;
        }
        printf("\n") ;
    }
    printf("\n\n") ;
}

void init(void)
{
    int* ptr = malloc((3 * 3) * sizeof(int));
 
    /* Putting 1 to 12 in the 1D array in a sequence */
    for (int i = 0; i < 3 * 3; i++)
        ptr[i] = i + 1;
 
    /* Accessing the array values as if it was a 2D array */
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++)
            printf("%d ", ptr[i * 3 + j]);
        printf("\n");
    }
 
    free(ptr);
}
int main(int argc,char*argv[])
{
 
  int ar1[3][3] = {{1 ,2 , 3} , {4,5,6},{7,8,9}} ;
  int ar2[][3] = {{1 ,2 , 3} , {4,5,6},{7,8,9}} ;

display(ar1 , 3, 3) ;
display(ar2 , 3, 3 ) ;

int len = sizeof(int* ) * 3 + sizeof(int) *3*3 ;
int **arr = malloc(len) ;
int count = 100 ;
    for(int i = 0 ; i< 3 ; i++)
    {
       arr[i] = (int*)malloc(3 * sizeof(int)); 
        for(int j = 0 ; j< 3 ; j++)
        {
            //printf("%d" , *( *(mat + i) + j) ) ;
            //printf("%d " , mat[i][j]) ;
           arr[i][j] = ++count ;
           printf("->%d \n" , arr[i][j]) ;
        }
    }

display2(arr , 3,3 ) ;
free(arr) ;
free(ar1) ;
free(ar2) ;
init() ;
return 0;
}
/*
// main()
char **array;
int SIZE;
// Initialization of SIZE is not shown, but let's assume SIZE = 50;
// Allocate table
array = (char **) malloc(SIZE * sizeof(char*));
  // Note: cleaner alternative syntax
  // array = malloc(sizeof *array * SIZE);
// Allocate rows
for (int row = 0; row<SIZE; row++) {
  // Note: sizeof(char) is 1. (@Carl Norum)
  // Shown here to help show difference between this malloc() and the above one.
  array[row] = (char *) malloc(SIZE * sizeof(char));
    // Note: cleaner alternative syntax
    // array[row] = malloc(sizeof(**array) * SIZE);
  }
// Initialize each element.
for (int row = 0; row<SIZE; row++) {
  for (int col = 0; col<SIZE; col++) {
    array[row][col] = 'a';  // or whatever value you want
  }
}

Resources: https://www.techiedelight.com/pass-2d-array-function-parameter/

*/