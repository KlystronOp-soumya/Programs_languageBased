#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n'

void printMat(int **mat , int rows , int cols){
    // Output
    for (int i = 0; i < rows; ++i)
    {
        cout << "[";
        for (int j = 0; j < cols; ++j)
        {
            cout << mat[i][j] << (j < cols - 1 ? ", " : "");
        }
        cout << "]\n";
    }
}

int main(int argc, char *argv[])
{
    // different ways for initializing an array
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    int *arr = new int[n]; // dynamically allocated array

    cout << "Enter " << n << " elements:\n";
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }

    // Print the array
    cout << "[";
    for (int i = 0; i < n; ++i)
    {
        cout << arr[i] << (i < n - 1 ? ", " : "");
    }
    cout << "]\n";

    // Free memory
    delete[] arr;

    int rows, cols;
    cin >> rows >> cols;

    int **mat = new int *[rows];
    for (int i = 0; i < rows; ++i)
    {
        mat[i] = new int[cols];
    }

    // Input
    for (int i = 0; i < rows; ++i)
        for (int j = 0; j < cols; ++j)
            cin >> mat[i][j];
/*
    // Output
    for (int i = 0; i < rows; ++i)
    {
        cout << "[";
        for (int j = 0; j < cols; ++j)
        {
            cout << mat[i][j] << (j < cols - 1 ? ", " : "");
        }
        cout << "]\n";
    }
*/
printMat(mat , rows , cols) ;
    // Clean up memory
    for (int i = 0; i < rows; ++i)
        delete[] mat[i];
    delete[] mat;

    return 0;
}