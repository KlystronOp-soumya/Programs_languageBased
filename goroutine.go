package main

import (
	"fmt"
	"time"
)

// code to understand the threading in GO

func say(s string, times int) {

	for i := 0; i < times; i++ {
		// inject a 100ms delay
		time.Sleep(1000 * time.Millisecond)
		fmt.Println(i, s)
	}
}

func goroutinedemo() {
	//say("Hello", 3)
	//say("World", 3)

	// convert it into go routine
	go say("Hello", 3)
	go say("World", 3)
	fmt.Scanln()

}
