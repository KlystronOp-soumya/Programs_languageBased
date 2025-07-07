package main

import "fmt"

/*
 function to filter out odd elements in array
 param1 : int array
 para2 	:  callback function to filter out odd
 returns : slice of even elements
*/
func filter(ar []int, isEven func(a int) bool) []int {
	filteredElems := make([]int, 0)
	fmt.Println("Length of ar: ", len(ar))
	for i := 0; i < len(ar); i++ {
		if isEven(ar[i]) {
			filteredElems = append(filteredElems, ar[i])
		}
	}
	return filteredElems
}

func funcAdvance() {
	//anonymous function
	var fooAnn func() int // a function fooAnn that returns integer

	fooAnn = func() int { return 13 }

	fmt.Println("The function returned: ", fooAnn())

	isEven := func(a int) bool { return a%2 == 0 }

	for i := range [10]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10} {
		fmt.Println(i, " even: ", isEven(i))
	}
	// Go does not have the filter method
	ar := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	f := filter(ar, isEven)
	fmt.Println("After filteration: ", f)

}
