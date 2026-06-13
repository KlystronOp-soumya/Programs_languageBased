#include <stdio.h>
#include "coordinates.h"

Point create_point(int x, int y)
{
    Point p = { x, y };
    return p;
}

void print_point(const Point* p)
{
    if (!p) return;

    printf("Point(%d, %d)\n", p->x, p->y);
}