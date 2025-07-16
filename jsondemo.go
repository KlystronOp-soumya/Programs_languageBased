package main

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
	"time"
)

type Name struct {
	FirstName string
	LastName  string
}

type Address struct {
	Line1 string
	Line2 string
	Line3 string
}

type Customer struct {
	Name    Name
	Email   string
	Address Address
	DOB     time.Time
}

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

	var result map[string]interface{}
	jsonString := `{
		"success" : true ,
		"timestamp" " 1588779306 ,
		"base" " "EUR" ,
		"date" : "2020-05-06" ,
		"rates" : {
			"AUD" : 1.683349 ,
			"CAD" : 1.528643 ,
			"GBP" : 0.874757 ,
			"SGD" : 1.534513 ,
			"USD" : 1.080054
		}
	}`

	json.Unmarshal([]byte(jsonString), &result)
	fmt.Println(result["success"])
	rates := result["rates"]
	fmt.Println(rates)
	currencies := rates.(map[string]interface{}) // asserts
	fmt.Println(currencies["USD"])

}

func encodeJson() {

	layoutISO := "2006-01-02"
	dob, _ := time.Parse(layoutISO, "2010-01-08")

	john := Customer{
		Name:  Name{FirstName: "John", LastName: "Doe"},
		Email: "johndoe.dev.@abc.com",
		Address: Address{
			Line1: "The White House",
			Line2: "1600 Pennsylvania Avenue Nw",
			Line3: "Washington, DC 20500",
		},
		DOB: dob,
	}
	johnJson, err := json.MarshalIndent(john, "", "    ")
	if err == nil {
		fmt.Println(string(johnJson))
	} else {
		fmt.Println(err)
	}
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
