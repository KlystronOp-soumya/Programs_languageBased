package main

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
)

type People struct {
	FirstName string
	LastName  string
	Details   struct {
		Height int
		Weight float32
	}
}

type Rates struct {
	Base   string `json: "base currency"`
	Symbol string `json: destination currency`
}

func mapUnstrucutredData() {

}

func mapCustomFields() {
	var rates Rates
	jsonString := `{
		"base currency" : "EUR" ,
		"destination currency" : "USD"
	}`
	json.Unmarshal([]byte(jsonString), &rates)
	fmt.Println(rates.Base)
	fmt.Println(rates.Symbol)

}

func decodeArray() {
	var persons []People
	jsonString := `[
		{
			"firstName": "John" ,
			"lastName" : "Doe" ,
			"details" :{
				"height" : 175 ,
				"weight" : 70.0
			}
		} ,

		{
			"firstName": "James" ,
			"lastName" : "DGosling" ,
			"details" :{
				"height" : 219 ,
				"weight" : 86.2
			}
		} 
	
	]`
	json.Unmarshal([]byte(jsonString), &persons)

	for _, person := range persons {
		fmt.Println(person.FirstName)
		fmt.Println(person.LastName)
		fmt.Println(person.Details.Height)
		fmt.Println(person.Details.Weight)
	}

}

func decode() {

	var person Person
	jsonString := `{"firstName" : "John" , "lastName" : "Doe"}` //json encoded data

	err := json.Unmarshal([]byte(jsonString), &person)
	if err == nil {
		fmt.Println(person.FirstName)
		fmt.Println(person.LastName)
	} else {
		fmt.Println(err)
	}
}

func jsonDemo() {
	log.SetOutput(os.Stdout)
	log.Println("Decoding the json")
	decode()
	log.Println("Decoding array of json")
	decodeArray()
}
