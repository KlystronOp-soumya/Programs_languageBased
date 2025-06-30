package main

import (
	"fmt"
	"os"
	"strings"
)

func fibonacci() {
//method to print the fibonacci series
max:=100 ;
term1,term2 := 0 ,1 ;
prev , next:=term1,term2 ;
println(prev)
for ;next <= max ; { //the two semicolons are not required for next<=max is enough
	println(next) ;
	curr:=prev+next ;
	prev=next ;
	next=curr;
}

}

func infiniteLoop()  {
	
	for {
		fmt.Println("Enter Q to exit") ;
		var input string ;
		fmt.Scanln(&input) ;
		if strings.ToUpper(input) == "Q" {
			break ;
		}
	}

}
func loopDemo() {
	//loops in Go
	//simple for loop
	count := 5
	for i := 0; i < count; i++ {
		fmt.Printf("i:%d " , i) ;
	}

	for i,j := 0 , 1; i < count; i,j= i+1, j+1 {
		fmt.Printf("i:%d " , i) ;
		fmt.Printf("j :%d " , j) ;
	}
fmt.Fprintln(os.Stdout , "\nFibonacci series:")
	fibonacci();
	infiniteLoop();

	var OS[3] string; 
	OS[0]="iOS" ; 
	OS[1]="Android" ;
	OS[2]="Windows" ;

	for i, v := range OS {
		fmt.Println(i,v) ; //i-index v-value
	}
	//Java like labeling is also possible

}