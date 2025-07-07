#include<bits/stdc++.h>
#define MAX_ELEM 100
using namespace std; 

class Shape
{
    //this is a abstract class that only defines the methods and instance vars
    protected:
     float height,length,breadth,width,radius ;
     public:
      Shape(float h, float l, float b)
      {
        height = h;
        length = l;
        breadth = b;
      }

      Shape(float r)
      {
        radius = r ;
      }

      Shape (float l, float b)
      {
        length = l ;
        breadth = b;
      }
    
        float calculate_area();
        float calculate_perimeter();
        float calculate_volume();

        void display() ;

        ~Shape()
        {
            cout<<"object destroyed" ;
        }
} ;

class Circle : public Shape
{
    private:
    const double PI = 3.14 ;
    float circ_area,perimeter ;

    public: //overrides
    Circle(float r) : Shape(r){}

    //overridden function as class definition to be declared
    float calculate_area();
    void display();

    ~Circle()
    {
      cout<<"Circle object destroyed" ;
    }
} ;

//definig the area for Circle

float Circle :: calculate_area()
{
    circ_area = PI*radius*radius  ;
    return circ_area;
}

void Circle :: display(void)
{
    cout<< "Area of the circle with radius: " << radius << " is: " <<circ_area;
}

class Rectangle: public Shape
{

} ;

int main(int argc,char*argv[])
{
  Circle c (10.0f) ;
  c.calculate_area() ;
  c.display() ;

return 0;
}