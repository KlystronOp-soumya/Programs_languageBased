#include <stdio.h>
#include <math.h>

typedef struct Point
{
	double x;
	double y;
} Point2D;

__declspec(dllexport) double calculate_distance(Point2D *p1, Point2D *p2)
{

	return sqrt(pow((p2->x - p1->x), 2) + pow((p2->y - p1->y), 2));
}

/*int main(int argc, char **argv[])
{

	Point2D point1 = {1.9, 2.0};
	printf("x:%f", point1.x);
	Point2D point2 = {0.0,0.0};

	printf("distance: %f", calculate_distance(&point1, &point2));
}*/