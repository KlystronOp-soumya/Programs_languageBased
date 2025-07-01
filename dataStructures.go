package main

import (
	"fmt"
	"strconv"
)


func arrayDemo() {
	//basic syntax var array_name [size_of_array] data_type
	var nums [5]int // int nums[5]
	fmt.Println(nums) ;

	//initilized
	nums2 :=[6]int {1,2,3,4,5,6} ;
	fmt.Println(nums2) ;

	//get the length
	fmt.Println("length of the array: " , len(nums));

	//multidimensional array
	var table [2][3] string ;
	for row := 0; row < 2; row++ {
		for col := 0; col < 3; col++ {
			table[row][col] = strconv.Itoa(row)+ ","+strconv.Itoa(col) ;

		}
	}

	var threeD [4][3][3] string ;

for row := 0; row < 4; row++ {
		for col := 0; col < 3; col++ {
			for dep := 0; dep < 3; dep++ {
				threeD[row][col][dep] = strconv.FormatInt(int64(row) , 10) + 	strconv.FormatInt(int64(col) , 10) + strconv.FormatInt(int64(dep) , 10)  		
			}
			
		}
	}

}