package main

import (
	"fmt"
	"os"
)

/*
There is no ternary operator in Go
*/
func doFoo()(int,bool){

	return 5,false ; //this is valid syntax in Go
}

func assignInIf(){
  
  //like python we can decons
  v1,err1 := doFoo();
  _=v1 ;
  _=err1;

  if err1{
	fmt.Fprint(os.Stderr , "There is error") ;
	
  }else{
	fmt.Fprint(os.Stdout , "There is no error") ;
  }

  //the assignment and check is also possible in the if
   if v2,err2 := doFoo(); !err2{
	fmt.Println(v2);
   }else{
	//handle error
	fmt.Println("Error: ", err2);
   }
}

func switchCase()  {
	num:=5;
	dow:="";

	switch num {
	case 1: dow="Mon" ; fmt.Println("Monday blues...") ;
	case 2: dow="Tue" ;
	case 3: dow="Wed" ;
	case 4: dow="Ths" ;
    case 5: dow="Fri" ; fmt.Println("TGIF!!")
	case 6: dow="Sun" ;
	default: dow="--error--" ;
		
	}

	fmt.Printf("%s is the day of week\n" , dow) ;

	grade:="C" ;
	switch grade {
	case "A" , "B" , "C" , "D":
		fmt.Println("Passed") ; //without the break statement it broke out of the switch statement once the condition is true
	case "F" : 
	    fmt.Println("Failed") ;
	default:
		fmt.Println("Undefined") ;
		
	}
grade1:="C" ;
	switch grade1 {
	case "A" , "B" , "C" , "D":
		fmt.Println("Passed fallthrough") ;
		fallthrough ; //upon validation it will not break and move to next case and will continue till default
	case "F" : 
	    fmt.Println("Failed fallthrough") ;
		fallthrough ;
	default:
		fmt.Println("Undefined fallthrough") ;
		
	}

    //switch case with expression
	score:=79 ;
	switch {
	case score<50: fmt.Println("F") ;
	case score<60: fmt.Println("D") ;
	case score<70 : fmt.Println("C") ;
    default: fmt.Println("A") ;
	}
}



func isEven(){

	var n int = 2 ;
	if (n%2==0){
		fmt.Printf("%d is an even" , n);
	}else{
		fmt.Printf("%d is odd" , n);
	}

}

func makedecesion() {
	//program to understand the if else
	var num int8
	num = 6
	var condition bool = num%2 == 0
	fmt.Println("The condition is:",condition);
	//the comparison operator is same as C lang
	isEven();
	assignInIf();
	switchCase() ;
}