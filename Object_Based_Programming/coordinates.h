/*
Header File: coordinates.h
*/
struct coordinate_s
{
    /*Pointers to the method functions*/
    void (*setx) (struct coordinate_s* , int ) ;
    void (*sety) (struct coordinate_s * , int ) ;
    void (*print) (struct coordinate_s *) ;
    /* data */
    int x , y ;
} ;

/*Constructor*/
struct coordinate_s *coordinate_create(void) ;
/*Destructor*/
void coordinate_destroy(struct coordinate_s *) ;

typedef struct coordinate_s coordinate ;
