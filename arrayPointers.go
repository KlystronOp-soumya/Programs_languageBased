package main

import "fmt"

func modifyMatrix(m *[3][4]int) {
	m[1][2] = 42
}

func createMatrix() {
	matrix := [3][4]int{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12},
	}

	modifyMatrix(&matrix)

	for i := 0; i < 3; i++ {
		for j := 0; j < 4; j++ {
			fmt.Printf("%d ", matrix[i][j])
		}
		fmt.Println()
	}
}

func arrayPointers() {
	var arr [3]int = [3]int{10, 20, 30}
	var ptr *[3]int = &arr
	fmt.Println((*ptr)[1]) // Access second element
	(*ptr)[1] = 99         //modify the value

	//Array of pointers
	var a = [3]int{10, 20, 30}
	var ptrs [3]*int

	for i := 0; i < 3; i++ {
		ptrs[i] = &a[i]
	}

	for i := 0; i < 3; i++ {
		fmt.Println(*ptrs[i])
	}

	createMatrix()

}
