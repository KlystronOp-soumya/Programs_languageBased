package main

import (
	"fmt"
)

/*
to execute this code
go build .\main.go
.\main.exe

or, go run .\main.go

now we need to compile both the files main.go and show_time.go
then use go build
*/
var globalNum int //explicitly defined
func main() {
	fmt.Println("Hello World")

	//call the displayTime from show_time
	displayTime()

	//declare variable
	var num1 = 5
	fmt.Println("The number is:", num1)

	fmt.Println("This is global:", globalNum)
	globalNum = 13
	fmt.Println("Assigned value into global:", globalNum)

	//define different types of variables
	var num2 int64
	var num3 float32
	var raining bool
	fmt.Println(num3)
	fmt.Println(num2)
	fmt.Println(raining)

	var rates float32 = 4.5
	fmt.Println(rates)

	fmt.Println("---------Variables demo start--------")
	variables()
	fmt.Println("----------Variables demo end----------")

	fmt.Println("---------String demo start------------")
	stringsDemo()
	fmt.Println("------------String demo end-----------")
	fmt.Println("---------TypeConversion demo start------------")
	typeconversion()
	fmt.Println("------------TypeConversion demo end-----------")
	//var dp [5]int
	//mymain() //uncomment for user input
	//parsing()
	//makedecesion()
	//loopDemo() ;
	//funcdemo()
	//fibonacci_dp(5, dp)
	//funcAdvance()
	//structdemo()
	//mapsdemo()
	//interfaces()
	//goroutinedemo()
	//sharedresources()
	//sharedresoucesAtomic()
	//synchronize()

}
