package main

import (
	"fmt"
	"math"
)

type Point struct {
	x float32
	y float32
	z float32
	Name []string
}

/*
	the following function is called constructor function
	Go does not have any constructor like feature
	this is idiomatice approach
*/
func newPoint(x,y,z float32) *point  {//returns address
	p:= point{x:x , y:y , z:z} ;
	return &p ;
	
}

//to associate this with the struct need to specify the receiver type
func (p point) length() float64 {
    return math.Sqrt(
        math.Pow(float64(p.x), 2) +
        math.Pow(float64(p.y), 2) +
        math.Pow(float64(p.z), 2),
    )
}

//this is a normal function
func getLength(pt point)  {
	fmt.Println("Get length");
}

func (p *point) move(deltax,deltay,deltaz float32)  {
	
	// C: p->x
	p.x+=deltax ;
	p.y+=deltay ;
	p.z+=deltaz ;
	
	
}


func structdemo() {

	//create variable or object of the struct type
	var pt1 point
	pt1.x = 2.1
	pt1.y = 3.1
	pt1.z = 4.1

	fmt.Println(pt1.x,pt1.y,pt1.z) ;

	//another way of declaring
	pt2:=point{x: 1.6 ,y: 2.2 ,z: 3.2};
	//or pt2:= point{1,2,3}
	fmt.Println(pt2.x , pt2.y , pt2.z) ;
	pt4 := newPoint(1,2,3) ; // no need for *pt4
	fmt.Println("As pointer: " , pt4) ;
	fmt.Println("Dereferenced[without *]: " , pt4.x) ;
	//if we do the following then both the pointers will point to the same memory location
	pt5 := pt4 ;
	fmt.Println(pt5) ;//same output

	//to create a independent copy
	pt6 := *pt4 ; //like C this is value at the address which is the struct variable at the address held by pt4
	fmt.Println(pt6) ;
	pt6.z = 13 ;
	fmt.Println(pt4,"\n" , pt6) ;

	pt7 := pt6 ;//points to the same shallow copy
	pt8 := &pt7 ; //points to the same pt6 and pt7 shallow copy
	fmt.Println(pt8) ;
	
	fmt.Println( pt8.length() );//function associated with the struct a method it is
	getLength(pt6) ; //function that takes argument a structure 

	//get a structure pointer
	var pt9 *point ;
	pt9=newPoint(7.8 , 9.1 , 2.3) ;
	pt9.move(0.1 , 0.2 , 0.3) ;
	fmt.Println(*pt9) ;

	pt10 := point{x:5.6 , y:3.8 , z:6.9 , name: []string{"pt10"}} ;
	pt11 := point{x:5.6 , y:3.8 , z:6.9 , name: []string{"pt11"}} ;

	fmt.Println(pt10 == pt11) ;
	
 
}