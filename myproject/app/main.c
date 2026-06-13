#include <stdio.h>
#include "coordinates.h"
#include "math_utils.h"

int main(void)
{
    Point p = create_point(3, 4);
    print_point(&p);

    printf("Add: %d\n", add(5, 3));
    printf("Sub: %d\n", sub(10, 4));

    return 0;
}