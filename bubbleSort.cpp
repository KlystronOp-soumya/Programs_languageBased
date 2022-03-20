//program to demonstrate the Bubble sort both basic and improoved version
#include <bits/stdc++.h>
using namespace std;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bubble_sort(int a[], int n)
{
    for (int step = 0; step < n - 1; ++step)
    {
        for (int i = 0; i < n - step - 1; ++i)
        { 
            if (a[i] > a[i + 1])
            {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            } 
                //swap(&a[i], &a[i + 1]);               
        }
    }
}

/* since the status of the swapping operation is kept the worst case is slightly improved to the O(n) */
void bubble_sort_imporved(int a[], int n)
{
    int swapped; //initialization
    for (int pass = n - 1; pass >= 0 && swapped; --pass)
    {
        //set
        swapped = 0;
        for (int i = 0; i < n - 1; ++i)
        {
            if (a[i] > a[i + 1])
            {
                swap(&a[i], &a[i + 1]);
                swapped = 1;
            }
        }
    }
}
void display(int *a, int n)
{
    for (int i = 0; i < n; ++i)
    {
        printf("%d ", *(a + i));
    }
}
int main(int argc, char const *argv[])
{
    /* code */
    int a[] = {13, 3, 63, 23, 83,-3};
    int b[] = {100, 0, -1, 76, 3,300};
    int n = 6;
    printf("before sorting:\n");
    display(a, n);
    bubble_sort(a, n);
    printf("after sorting:\n");
    display(a, n);
    printf("before sorting:\n");
    display(b, n);
    bubble_sort_imporved(b, n);
    printf("after sorting:\n");
    display(b, n);

    return 0;
}
