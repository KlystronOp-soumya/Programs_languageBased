package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

var balance int // common resource used by the threds
// to synchronize use mutex
var mutex = &sync.Mutex{} //return address

func credit() {
	for range 5 {
		mutex.Lock() // lock the thread while inside
		balance += 100
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)

		fmt.Println("After crediting, balance is: ", balance)
		mutex.Unlock()
	}
	//release
}

func debit() {
	for range 5 {
		mutex.Lock()
		balance -= 100
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
		fmt.Println("After debiting, balance is: ", balance)
		mutex.Unlock()
	}
}

func sharedresources() {
	balance = 200
	fmt.Printf("initial balance is: %d\n", balance)
	go credit()
	go debit()
	fmt.Scanln()
}
