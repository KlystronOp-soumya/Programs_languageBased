#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

/**
 * @brief Creates a 2D array (array of pointers) dynamically.
 * @param rows The number of rows.
 * @param cols_per_row An array specifying the number of columns for each row.
 * @return A pointer to the dynamically allocated 2D array, or NULL on failure.
 */
int** createRagged2DArray(int rows, int* cols_per_row) {
    // 1. Allocate memory for 'rows' number of integer pointers (int*)
    // This will hold the starting address of each row.
    int** arr = (int**)malloc(rows * sizeof(int*));
    if (arr == NULL) {
        perror("Failed to allocate memory for row pointers");
        return NULL; // Return NULL if allocation fails
    }

    // 2. For each row pointer, allocate memory for its columns
    for (int i = 0; i < rows; i++) {
        // Allocate memory for 'cols_per_row[i]' integers for the current row.
        arr[i] = (int*)malloc(cols_per_row[i] * sizeof(int));
        if (arr[i] == NULL) {
            perror("Failed to allocate memory for a row");
            // Clean up previously allocated rows if current allocation fails
            for (int j = 0; j < i; j++) {
                free(arr[j]);
            }
            free(arr);
            return NULL;
        }
    }
    return arr;
}
/**
 * @brief Creates a 2D array (contiguous block) dynamically.
 * @param rows The number of rows.
 * @param cols The number of columns for each row.
 * @return A pointer to the dynamically allocated contiguous block, or NULL on failure.
 */
int* createContiguous2DArray(int rows, int cols) {
    // Allocate memory for rows * cols number of integers in a single block.
    int* arr = (int*)malloc(rows * cols * sizeof(int));
    if (arr == NULL) {
        perror("Failed to allocate memory for contiguous 2D array");
    }
    return arr;
}

/**
 * @brief Prints a 2D array created using the array of pointers method.
 * @param arr The 2D array (array of pointers).
 * @param rows The number of rows.
 * @param cols_per_row An array specifying the number of columns for each row.
 */
void printRagged2DArray(int** arr, int rows, int* cols_per_row) {
    printf("\n--- Ragged 2D Array Content ---\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols_per_row[i]; j++) {
            printf("%d ", arr[i][j]); // Accessing elements like a normal 2D array
        }
        printf("\n");
    }
}

/**
 * @brief Prints a 2D array created using the single pointer (contiguous block) method.
 * @param arr The pointer to the contiguous block.
 * @param rows The number of rows.
 * @param cols The number of columns.
 */
void print_contiguos_2d_array(int *arr ,int rows , int cols){

    printf("Array elements (using pointer arithmatic)\n") ;
    for (int i = 0; i < rows; i++)
    {
            for (int j = 0; j < cols; j++)
            {
                // Access elements using pointer: *(base_address + row_index * num_cols + col_index)
                printf("%d" , *(arr + i*cols + j)) ;
            }
            
    }
}

/**
 * @brief Prints a 2D array created using the single pointer (contiguous block) method,
 * by casting it to a pointer to an array type. This allows array-like indexing.
 * @param arr A pointer to an array of integers (e.g., int (*)[cols]).
 * @param rows The number of rows.
 * @param cols The number of columns.
 * @note This function signature requires 'cols' to be a compile-time constant if used directly
 * with `int arr[][COLS]`. For dynamic arrays, you cast the `int*` to `int (*)[cols]`.
 */


void print_arr_as_pointers_to_arr( int rows, int cols , int (*arr)[cols]) {
    printf("Array elements (using pointers to an array):\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", *(*(arr + i) + j));  // or simply arr[i][j]
        }
        printf("\n");
    }
}

void print_arr_using_row_major(int **arr , int r, int c){

    for(int *p = &arr[0][0] ; p <= &arr[r-1][c-1] ; p++)
    {
        printf("%d" , *p) ;
    }
}

/**
 * @brief Frees memory allocated for a 2D array created using the array of pointers method.
 * @param arr The 2D array (array of pointers).
 * @param rows The number of rows.
 */
void deallocateArray(int **arr , int rows){
    if(arr == NULL) return ;

    //Free memory for each row first
    for (int i = 0; i < rows; i++)
    {
        free(arr[i]) ;
        arr[i]=NULL ; //good practice set null once freed
    }
    free(arr) ;
    arr=NULL;
    printf("Ragged array was freed");
}
/**
 * @brief Frees memory allocated for a 2D array created using the single pointer method.
 * @param arr The pointer to the contiguous block.
 */
void deallocateArray2(int *ar){
    free(ar) ;
    printf("Contiguous 2D array memory freed!") ;
}

int main(int argc, char* argv[])
{
    

    return 0 ;
}