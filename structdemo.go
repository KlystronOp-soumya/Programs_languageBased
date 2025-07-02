package main

import (
	"fmt"
)

type point struct {
	x float32
	y float32
	z float32
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
	fmt.Println(pt2.x) ;
	pt4 := newPoint(1,2,3) ; // no need for *pt4
	fmt.Println(pt4) ;
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
	

}