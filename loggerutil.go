package main

import (
	"log"
)

// LogValue logs any type of value using Go generics
func LogValue[T any](label string, value T) {
	log.Printf("%s: %+v\n", label, value)
}
func Info[T any]( msgLabel string, value ... T)  {
	
	for _, test := range value {
		log.Println(msgLabel,":: " , test) ;
	}
}