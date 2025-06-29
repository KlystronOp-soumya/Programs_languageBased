package main

import (
	"fmt"
	"os"
	"strconv"
)

func userinput() {

	var age int ;
	var name string;
	fmt.Println("Please enter your name: ");
	fmt.Scanf("%s" , &name);//need to clear out the buffer
	fmt.Println("Please enter your age: ");
	fmt.Scanf("%d" , &age);
	
	
	fmt.Println("Age is: " , age , "and name is: " , name) ;
	fmt.Fprintln(os.Stdout, "Hello from os.Stdout!")

	var input string ;
	fmt.Scanf("%s" , &input);
	age,err := strconv.Atoi(input) ;

	if err!=nil{
		fmt.Fprintln(os.Stderr , err) ;
	}else{
		fmt.Println(age) ;
	}
}

func mymain() {

	userinput()

}