#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
using namespace std;
#define END_LINE '\n'

class Shape
{

public:
    double h, w, b;
    double area(double h, double b);
    double area(double h, double w, double b);
    double area(double s);
};

class Box : public Shape // extends Shape
{
private:
public:
    Box() {}
    ~Box() {}

    Box(const double height, const double width, const double breadth)
    {
        this->h = height;
        this->b = breadth;
        this->w = width;
    }

    double area()
    {
    }
};

int main(int argc, char *argv[])
{

    return 0;
}