#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

//function signatures
void deallocte_single_block(int** arr, int r, int c);
void deallocate(int **arr ,int r) ;
void printElems1(int** arr, int r, int c);
void printElems2(int (*ar)[4] , int row, int col) ;

int** create_twod_contiguous(int r,int c, int init)
{
    if(r <= 0 || c<=0) return NULL ;
    //Allocate single block of data
    int* data = (int*)malloc(r*c*sizeof(int)) ;
    if(data==NULL)
    {
        perror("Failed to allocate main data block"); return NULL ;
    }
    //Allocate the array of row pointers
    int** arr = (int**) malloc(r*sizeof(int*)) ;
    if(arr==NULL)
    {
        perror("Failed to allocate row pointers");
        free(data);
        return NULL;
    }
    for (int i = 0; i < r; i++)
    {
        arr[i] = data+ (i*c) ;//Pointer arithmatic
        for (int j  = 0; j < c; j++)
        {
            arr[i][j] = init++ ;
        }
        
    }
    return arr ;
    
}

//C99 standard
int (*create_2d_vla(int rows, int cols , int init_val))[cols]{

    int(*arr)[cols] = (int (*)[cols])malloc(rows*cols*sizeof(int)) ;

}

void process_arr_vla(int rows,int cols, int(*arr)[cols]){
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        printf("%d" , arr[i][j]);
      }
      
    }
    
}
int main(int argc, char* argv[])
{
    int rows = 3, cols = 4;
    int* matrix = malloc(rows * cols * sizeof(int));

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            *(matrix + i * cols + j) = i + j;  // or matrix[i * cols + j]
        }
    }

    int** matrix2 = malloc(rows * sizeof(int*));
    for (int i = 0; i < rows; i++)
        matrix2[i] = malloc(cols * sizeof(int));
    return 0;
}

void deallocte_single_block(int **matrix , int row , int col){

    if(matrix == NULL)
    {
        perror("can not deallocate");
        return;
    }
    free(matrix[0]) ;
    free(matrix);
}

void deallocate(int **matrix , int row)
{
    for (int i = 0; i < row; i++)
    {
        /* code */
        free(matrix[i]);
    }
    free(matrix) ;
    
}

void freeup(int(*arr)[])
{
    free(arr) ;
}