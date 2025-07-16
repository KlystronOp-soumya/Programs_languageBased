package main

import (
	"fmt"
	"time"
)

// --send data into a channel--
func sendData(ch chan string) {

	fmt.Println("Sending a string intp  channrl...")
	time.Sleep(2 * time.Second)
	ch <- "Hello"
}

func getData(ch chan string) {
	fmt.Println("String retrieved from channel: ", <-ch)
}

func channelDemo() {
	ch := make(chan string)
	go sendData(ch)
	go getData(ch)

	fmt.Scanln()

}
