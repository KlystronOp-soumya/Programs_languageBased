#include "coordinates.h" 
#include <stdio.h>
#include <stdlib.h>

/*Method implementation */
static void coordinate_setx(coordinate* this, int x)
{
    if (this != NULL) (*this).x = x;
}

static void coordinate_sety(coordinate* this, int y)
{
    if (this != NULL) this->y = y;
}


static void coordinate_print(coordinate* this)
{
    if (this != NULL)
    {
        printf("Coordinate[x=%i , y=%i]\n", this->x, this->y);
    }
    else
    {
        fprintf(stderr, "NULL pointer exception! \nStackTrace: Create object\n");
    }

}

/*Constructor*/
coordinate* coordinate_create(void)
{
    //allocate memory with the same size of the structure
    coordinate* c = malloc(sizeof(*c));
    if (c != NULL)
    {
        c->setx = &coordinate_setx; //store the address of the function 
        c->sety = &coordinate_sety;
        c->print = &coordinate_print;
        c->x = 0;
        c->y = 0;
    }

    return c; //returns the structure address / pointer
}

/*Destructor*/
void coordinate_destroy(coordinate* this)
{
    if (this != NULL)
    {
        free(this);
    }
}
