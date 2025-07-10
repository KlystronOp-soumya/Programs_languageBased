package main

import (
	"fmt"
	"math/rand"
	"sync"
	"sync/atomic"
	"time"
)

var lumpSum int64
var mx = &sync.Mutex{}

func creditToLumpSum(wg *sync.WaitGroup) {

	defer wg.Done()
	for range 10 {
		mx.Lock()
		atomic.AddInt64(&lumpSum, 100)
		fmt.Println("Current balance[Cr]+ ", lumpSum)
		time.Sleep(2000 * time.Millisecond)
		mx.Unlock()
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
	}
}

func debitToLumpSum(wg *sync.WaitGroup) {
	defer wg.Done()

	for range 10 {
		mx.Lock()
		atomic.AddInt64(&lumpSum, -100)
		fmt.Println("Current balance[Dr]- ", lumpSum)
		time.Sleep(2000 * time.Millisecond)
		mx.Unlock()
		time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)

	}
}

func synchronize() {
	// to print the interim values use mutex
	// create the WaitGroup
	var wg sync.WaitGroup

	lumpSum = 200
	fmt.Println("Inital balance: ", lumpSum)

	wg.Add(1)
	go creditToLumpSum(&wg)

	wg.Add(1)
	go debitToLumpSum(&wg)

	wg.Wait()
	fmt.Println("Final balance is: ", lumpSum)

}
