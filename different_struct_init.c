#pragma GCC optimize("Ofast")
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stddef.h>
#include<windows.h>
#define MAX_ELEM 100 

#define END_LINE "\n" 

/*struct Point {

    int x;
    int y;
};*/ //w1

typedef struct {

    int x;
    int y;
}Point;

int main(int argc, char* argv[])
{
    /*
    struct Point p1 = { 0 };
    struct Point p2 = { 10, 20 };
    */

    Point p3 = { 30, 40 };
    //C99 style
    Point p4 = {
        .x = 50,
        .y = 60
    };

    Point p6;
    p6.x = 80;
    p6.y = 90;

    struct {
        int id;
        char name[20];
    } student = { 1, "Alice" };

    //Nested struct
    struct Rectangle {
        Point topLeft;
        Point bottomRight;
    };

    struct Rectangle rect = { {0, 0}, {10, 10} };

    //Compound literals
    Point* p8 = &(Point) { 300, 400 };


    return 0;
}