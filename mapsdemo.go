package main

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



}