package main

import (
	"fmt"
	"reflect"
	"time"
)

func typeconversion() {
	//program to find the types of variable and the data structures
	firstName, lastName, age := "John", "Doe", 25
	fmt.Println(firstName,lastName,age);
	start := time.Now() ;
	fmt.Print("current time: ",start) ;

	fmt.Printf(" typeof start: %T\n" , start)
	fmt.Printf("type of firstName: %T\n" , firstName)
	fmt.Printf("typeof age:%T\n" , age)

	fmt.Println(reflect.TypeOf(start))
	fmt.Println("dtatstructure firstName: " , reflect.TypeOf(firstName).Kind())
	fmt.Println("datastructure age:" , reflect.TypeOf(age))
}