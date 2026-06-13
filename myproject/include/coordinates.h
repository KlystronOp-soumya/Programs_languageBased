#ifndef COORDINATES_H
#define COORDINATES_H

typedef struct {
    int x;
    int y;
} Point;

Point create_point(int x, int y);
void print_point(const Point* p);

#endif