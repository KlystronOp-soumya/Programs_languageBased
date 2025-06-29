package main

import "fmt"

func variables()  {
	
	//short variable declaration
	firstName:= "John Doe" ;
	fmt.Println("Name:" , firstName);

	//deconstruct like python
	firstName,lastName , age := "John" , "Doe" , 25 ;//this can not be used out side the function body in Global
	fmt.Println(firstName,lastName,age) ;

	//we can use with var, then all the variable type should be homogeneous
	// the below code is not valid due to age is an int
  	//	var firstName,lastName , age = "John" , "Doe" , 25 ;
	var fname,lname = "Doe" , "John" ;// this is a valid statement but compiler will throw error satting not used vars

	// to address this assign these to blank
	_= fname
	_= lname
	//otherwise
	var(
		fName string = "John"
		lName string = "Doe"
		age2 = 26 //.\variables.go:27:3: declared and not used: age2
	)
	_=fName
	_=lName
	_=age2 //if not assigning to the blank identifier it will show the above message

	//using constant variable
	const email string ="go.lang@google.com" ;
	fmt.Println("Constant email:" , email) ;
}