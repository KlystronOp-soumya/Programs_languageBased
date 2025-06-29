package main

import "fmt"

func strings() {
	//strings in go lang
	//declare strings
    var firstName string = "John Doe" ;
	fmt.Println(firstName)
	//with escape modifiers
	address:= "The Whitre House\n1600 Pennsylvania Ave.\n WDC"
	fmt.Println(address)
	//raw string
	rawStr:=`
			"this is a raw string"
	` ;
	println(rawStr);

}