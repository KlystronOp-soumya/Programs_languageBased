package main

import (
	"fmt"
	"math"
)

type Person struct {
	firstName string
	lastName  string
	age       int
}

type Circle struct {
	radius float64
	name   string
}

type Square struct {
	length float64
	name   string
}

type Shape interface {
	Area() float64
}

// define the interface
type DigitsCounter interface {
	CountOddEven() (int, int)
}

// define a custom type
type DigitsString string

// Circle implements Shape
func (c Circle) Area() float64 {

	return math.Pi * math.Pow(c.radius, 2)
}

// Square implements Shape
func (s Square) Area() float64 {
	return math.Pow(s.length, 2)
}

// DigitsString implements DigitsCounter
func (ds DigitsString) CountOddEven() (int, int) {

	odds, evens := 0, 0
	for _, digits := range ds {
		if digits%2 == 0 {
			evens++
		} else {
			odds++
		}
	}
	return odds, evens
}

// we can attach a function as method to struct
func (c Circle) Circumference() float64 {

	return 2 * math.Pi * c.radius
}

// generic with interface
func doSomething(val interface{}) {
	fmt.Println(val)
}

func interfaces() {

	s := DigitsString("123456789")
	fmt.Println(s.CountOddEven())

	var d DigitsCounter // similar to Intf intf
	d = s               // intf = new IntfImpl()

	fmt.Println(d.CountOddEven())

	//create object
	c1 := Circle{radius: 5, name: "c1"}
	s1 := Square{length: 4, name: "s1"}
	fmt.Println("Area of the circle: ", c1.Area())
	fmt.Println("Circumference of the circle: ", c1.Circumference())
	fmt.Println("Aread of the square:", s1.Area())
	doSomething(1)
	doSomething(3.5)
	doSomething(c1)
}
