package main

import (
	"fmt"
	"sort"
)

/*
  Map<String , Integer> - Java
  map<String, int> - cpp
*/
var heights map[string]int ;

func mapsdemo() {

	//create the map as this is a type reference type
	heights= make(map[string]int) ;
	heights["Peter"] = 170 ;
	heights["Joan"] = 168 ;
	heights["Jan"] = 175 ;

	LogValue("heights" , heights) ;

	//initialize map with the map literal
	marks := map[string]float32{
		"John Doe" : 99.9 ,
		"Jane Max" : 100.0 , //end with an extra comma
	} ;
	LogValue("marks" , marks) ;
	//delete a key in map
	delete(marks , "Jane Max");

	if v,ok := heights["Peter"]; ok{
		Info("Found" , v , 1) ;
	}

	fmt.Println(marks);
	fmt.Println("Length of the map: " , len(heights))

	//iterate
	for k,v := range heights {
		fmt.Println(k ,"->" , v);
	}
	//get all the keys in map
	var keys []string ;
	for k := range heights {
		keys =append(keys, k) ;
	}
	fmt.Println(keys)
	//sort the keys
	sort.Strings(keys)
	fmt.Println("after sorting", keys) ;

}