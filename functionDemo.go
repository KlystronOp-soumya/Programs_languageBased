package main

import (
	"fmt"
	"os"
	"time"
)

/*
	Function overloading is not supported in Go
	Basic syntax: func <<functioinName>>(<<arg1>> , <<arg2>>) return_type{functionBody}
*/
func displayDate() {
	fmt.Println(time.Now());
}

func displayDateFmt(format string)  {
	fmt.Println(format);
}

//unlike other static typed program the data type is written later
func displayDateFmtPref(prefix string , format string){

	fmt.Println(prefix , format) ;
}

func passByValue( x int , y int)  {
	
	x,y=y,x ;
	fmt.Println("During swapping the values: " , x ," " , y );
}

//like C we can also pass the reference using pointer
//unlike CPP it does not support pass by reference
func passByPointer( a *int , b *int)  {
	// var temp *int = nil; //this is null pointer dereference
	var temp *int = new(int) ; //this dynamically allocates
	*temp=*a ;
	*a=*b;
	*b=*temp ;

	/*
	  *a,*b = *b, *a
	*/

}

//function returning values
func sum(a,b int) (int)  {
	
	return a+b ;
}
/*
	function to find the odd and even numbers in a range
*/
func findOddEvenInRange( start int , end int) (int,int)  {
	var evenCount int=0 ;
	var  oddCount int=0;	
	for i := start; i <= end; i++ {
		if(i%2 == 0){
			evenCount++ ;
		}else{
			oddCount++;
		}
	}

	return evenCount,oddCount ;
}

/*
  program to get familiar with the Go syntax
*/
func  countOddEven(s string) (int,int)  {
	odds,evens := 0,0 ;
	for _,c := range s {
		// for _ in range(s) like python, _ -> index , c-> value
		if int(c)%2==0 {
			evens++ ;
		}else{
			odds++
		}
	}
	return odds,evens;
}

/*
variadic
*/
func addNums(nums ...int) int {
	total:=0 ;
	for _ , n  := range nums{
		total+=n ;
	}
	return total ;
}
func funcdemo() {
	var x,y int ;
	x=3;
	y=13;
	//function call
	displayDate();
	//function call with arguments
	displayDateFmt(time.Now().Format("Sun 1997-08-03 19:32:13")) ;
	//function call with multiple arguments
	displayDateFmtPref("Current Date and Time" , "Sun 1997-08-03 19:32:13" ) ;
	fmt.Println("Before swapping the values: " , x ," " , y )
	passByValue(x,y) ;
	fmt.Println("After swapping the values: " , x ," " , y )
	passByPointer(&x, &y) ;
	fmt.Println("After swapping the values[byPointer]: " , x ," " , y )
	fmt.Println("Sum of the numbers: " ,sum(x,y));

	var start , end int=1,20 ;
	var ec,oc = findOddEvenInRange(start , end) ;

	fmt.Fprintf(os.Stdout , "even numbers: %d odd number %d between %d - %d" , ec , oc,start,end) ;
	countOddEven("12345");
	fmt.Println(addNums(1,2,3,4,5) , addNums(1,2,3))
}