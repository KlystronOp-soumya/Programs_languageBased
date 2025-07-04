package main

import (
	"fmt"
	"math"

	"github.com/google/go-cmp/cmp"
)

type Point struct {
	X float32
	Y float32
	Z float32
	Name []string
}

/*
	the following function is called constructor function
	Go does not have any constructor like feature
	this is idiomatice approach
*/
func newPoint(x,y,z float32) *Point  {//returns address
	p:= Point{X:x , Y:y , Z:z} ;
	return &p ;
	
}

//to associate this with the struct need to specify the receiver type
func (p Point) length() float64 {
    return math.Sqrt(
        math.Pow(float64(p.X), 2) +
        math.Pow(float64(p.Y), 2) +
        math.Pow(float64(p.Z), 2),
    )
}

//this is a normal function
func getLength(pt Point)  {
	fmt.Println("Get length");
}

func (p *Point) move(deltax,deltay,deltaz float32)  {
	
	// C: p->x
	p.X+=deltax ;
	p.Y+=deltay ;
	p.Z+=deltaz ;
	
	
}
/*
func (p1 Point) Equal(p2 Point) (bool)  { //overrides the method in cmp
	
	if p1.x == p2.x && p1.y == p2.y && p1.z == p2.z{
		return  true ;
	}
	return false

}*/

func structdemo() {

	//create variable or object of the struct type
	var pt1 Point
	pt1.X = 2.1
	pt1.Y = 3.1
	pt1.Z = 4.1

	fmt.Println(pt1.X,pt1.Y,pt1.Z) ;

	//another way of declaring
	pt2:=Point{X: 1.6 ,Y: 2.2 ,Z: 3.2};
	//or pt2:= Point{1,2,3}
	fmt.Println(pt2.X , pt2.Y , pt2.Z) ;
	pt4 := newPoint(1,2,3) ; // no need for *pt4
	fmt.Println("As Pointer: " , pt4) ;
	fmt.Println("Dereferenced[without *]: " , pt4.X) ;
	//if we do the following then both the Pointers will Point to the same memory location
	pt5 := pt4 ;
	fmt.Println(pt5) ;//same output

	//to create a independent copy
	pt6 := *pt4 ; //like C this is value at the address which is the struct variable at the address held by pt4
	fmt.Println(pt6) ;
	pt6.Z = 13 ;
	fmt.Println(pt4,"\n" , pt6) ;

	pt7 := pt6 ;//Points to the same shallow copy
	pt8 := &pt7 ; //Points to the same pt6 and pt7 shallow copy
	fmt.Println(pt8) ;
	
	fmt.Println( pt8.length() );//function associated with the struct a method it is
	getLength(pt6) ; //function that takes argument a structure 

	//get a structure Pointer
	var pt9 *Point ;
	pt9=newPoint(7.8 , 9.1 , 2.3) ;
	pt9.move(0.1 , 0.2 , 0.3) ;
	fmt.Println(*pt9) ;

	pt10 := Point{X:5.6 , Y:3.8 , Z:6.9 , Name: []string{"pt10"}} ;
	pt11 := Point{X:5.6 , Y:3.8 , Z:6.9 , Name: []string{"pt11"}} ;

	//Reason for capitalize: in Go to export a method/struct the name has to be in Caps

	fmt.Println("comapring the points: ", cmp.Equal(pt10 ,pt11));//false
	
 
}