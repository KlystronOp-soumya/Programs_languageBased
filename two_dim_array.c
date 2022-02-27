#include<stdio.h>
#include<stdlib.h>
void display(int q[][3],int row,int col)//q[3][3]
{
    printf("inside display func: \n");
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            printf("%d ",q[i][j]);
        }
        printf("\n") ;
        
    }
    
}

void disp_pointer(int *p,int r,int c)
{
    int i,j ;
    for(i = 0 ;i<r;++i)
    {
        for(j=0;j<c;++j)
        {
            printf("%d ", *(p+ i*c +j)) ;
        }
        printf("\n") ;
    }
}

void disp_pointer_2(int (*q)[3],int row,int col)
{
    int *p;
    for(int i =0;i<row;i++)
    {
        p=q+i;//base address of each 1D array
        for(int j = 0;j<col;j++)
        {
            printf("%d ",*(p+j));//q+i+j;

        }
        printf("\n");
    }
}
void disp_pointer3(int **q,int r,int c)
{
    for(int i = 0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
            printf("%d ",*(*q+(i*c)+j)) ;
        }
        printf("\n");
    }
}
int main(int argc, char const *argv[])
{
    int ar[3][3]= {
            {1,2,3},
            {6,4,5},
            {7,8,9}
    } ;

    int ar2[][4]={1,2,3,4,5,6,7,8,9} ;

    int row=sizeof(ar)/sizeof(ar[0]),col=sizeof(ar[0])/sizeof(int); 
    printf("ar=%d Row=%d and Column=%d \n",sizeof(ar),row,col) ;

    printf("elem=%d\n",ar[0][0]);
    for (int i = 0; i < row; i++)
    {
        //printf("%u \n",ar[i]) ;//&ar[0]
       // printf("%u \n",(ar+i));
        //printf("%u \n",*(ar+i));
        //printf("%u \n",&ar[i][0]);
        for (int j = 0; j < col; j++)
        {
            //printf("%d ",ar2[i][j]) ;
            printf("%d ",*(ar[i] + j)) ; //*(*(ar+i)+j) ->ar-> &ar[0]+4
        }
        printf("\n") ;        
    }
    int *p=&ar[0][0] ;
    int **m=&p;
    //display(ar,row,col) ;
    //disp_pointer(ar,row,col) ;
    disp_pointer3(m,row,col) ;
    //printf("address of  main is %u",&main) ;
    

    return 0;
}
