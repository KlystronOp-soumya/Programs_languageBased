#include<stdio.h>
#include<stdlib.h>

void swap(int *a,int *b)
{
    
}
void sort_array(int *ar,int n)
{
    for(int i = 0 ;i<n;++i)
    {
        for(int j = 1;j<n-i-1 ;++j)
        {
            
        }
    }

}

int* populate_array(int *ar,int *n)
{    
    printf("Enter the number of elements: \n");
    scanf("%d",n);
    int t = *n;
    ar=(int * )malloc(sizeof(int)*(t)) ;
    for(int i = 0 ;i<t;i++)
    {
        scanf("%d",ar+i);
    }
    return ar;
}
void display(int *ar,int n)
{
    printf("Displaying the array::\n");
    for(int i = 0; i<n; i++)
    {
        printf("%d ",ar[i]);
    }
}
void deallocate(int *ar)
{
    printf("In deallocate:: deallocated successfully") ;
    free(ar);
}
void service(int *ar)
{
    int n ;
    int* (*fun_ptr)(int*,int*) = populate_array ;
    ar = fun_ptr(ar,&n);
    printf("In service:: size of the array is: %d\n",n);
    void (*fptr)(int *,int) = display ;
    fptr(ar,n) ;


    deallocate(ar) ;
     free(fun_ptr) ;
    free(fptr);
}

int main(int argc, char const *argv[])
{
    int *ar ;
    service(ar);
    
    return 0;
}
