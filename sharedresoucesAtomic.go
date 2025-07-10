package main

import (
	"fmt"
	"math/rand"
	"sync/atomic"
	"time"
)

// credit and debit using Atomic

var amountLeft int32

func creditAmount() {
	for range 5 {
		//adds 100 to the balance
		atomic.AddInt32(&amountLeft, 100)
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
	}
}

func debitAmount() {
	for range 5 {
		//deducts 100 to the balance
		atomic.AddInt32(&amountLeft, -100)
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
	}
}

func sharedresoucesAtomic() {

	amountLeft = 200
	fmt.Println("initial balance: ", amountLeft)
	go creditAmount()
	go debitAmount()
	fmt.Scanln()
	fmt.Println("End balance: ", amountLeft)

}
