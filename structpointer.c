#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

typedef struct POINT
{
    float x;
    float y;
}Point;

void show_point(Point* p)
{
    printf("Coodirnates are: \n");
    printf("(x,y) : (%f,%f)\n", p->x, p->y);
    printf("(x,y) : (%f,%f)\n", (*p).x, (*p).y);
}

void show_point_vars(Point p)
{
    printf("Coodirnates are: \n");
    printf("(x,y) : (%f,%f)\n", p.x, p.y);
    
}
void show_point_double_pointer(Point** p)
{
    Point ptr = **p; //returns the pointer variable
    Point* pt = *p; //return the address of the structure
    printf("Double pointer-(x,y) : (%f,%f)\n", ptr.x, ptr.y);
}

void show_array_pointers(Point **ptArr){
  
    for (int i = 0; i < 2; i++)
    {
        /* code */
        printf("Point %d: x = %f, y = %f\n", i, ptArr[i]->x , ptArr[i]->y);
        printf("Point %d: x = %f, y = %f\n", i, (*(ptArr + i))->x, (*(ptArr + i))->y);
        printf("Point %d: x = %f, y = %f\n", i, (*( *(ptArr + i) )).x, (*( *(ptArr + i) )).y);
    }
    
}
void show_array_of_points(Point** ptrArr, int size) {

    int len = sizeof(*ptrArr) / sizeof(Point);
    printf("Size of the array is: %d", len);
    for (int i = 0; i < size; i++) {
        /*
            int *ar -> (ar+i) ;
            int **ar-> (*ar+i)
        */
        show_point(*ptrArr + i) ;
        
    }

}
int main(int argc, char* argv[])
{
    Point p1;
    p1.x = 1; p1.y = 2;

    Point* p2 = (Point*)malloc(sizeof(Point) * 1);
    p2->x = 4;
    p2->y = 5;

    show_point(&p1);
    show_point(p2);
    show_point_double_pointer(&p2);
    
    
    Point* ptrArr = (Point*)malloc(sizeof(Point) * 2);
    ptrArr[0] = p1;
    // ptrArr[1] = p2 ; its wrong as it is not array of ppointers
    ptrArr[1] = *p2;

    show_array_of_points(&ptrArr,2);

    //define an array of pointers
    Point *ptrPtArr[2] ;
    ptrPtArr[0] = &p1 ;
    ptrPtArr[1] = p2 ;//p2 already holds an address as this is pointer variable
    /*
        while we pass an array it goes as pointer
        while we are passing an array of pointers it is going &(*arr) so Point **
    */
    show_array_pointers(ptrPtArr) ; 
    //define an pointer to an array
    Point points[2] ;
    points[0]=p1 ;
    points[1]=*p2 ;
    Point (*pointer_to_PointArr)[2];
    pointer_to_PointArr = &points ; //this allocates the memory of the first element
    printf("First point: (%f, %f)\n", (*pointer_to_PointArr)[0].x, (*pointer_to_PointArr)[0].y);
    printf("First point: (%f, %f)\n", (*pointer_to_PointArr)[1].x, (*pointer_to_PointArr)[1].y);




    free(ptrArr);
    free(p2);
    return 0;
}