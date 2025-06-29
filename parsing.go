package main

import (
	"fmt"
	"strconv"
)

func parsing() {
	//program to parse different data types
	b, err := strconv.ParseBool("t")
	fmt.Println(b) ;
	fmt.Println(err)
	fmt.Printf("%T\n" , b) ;

	f,err := strconv.ParseFloat("3.1415" , 64) ; //second argument is the bitsize
	fmt.Println(f);
	fmt.Println(err);
	fmt.Printf("%T\n" , f);

	i,err := strconv.ParseInt("3.1415" , 10,64) ; //second argument is the radix
	fmt.Println(i);
	fmt.Println(err); //shows error
	fmt.Printf("%T\n" , i);


}