package main

import (
	"fmt"
	"sync"
	"time"
)

type PubSub struct {
	messages []string
	lock     sync.Mutex
}

/*
This is a method for PubSub class
@param message String
@return void
*/
func (ps *PubSub) publish(msg string) {
	ps.lock.Lock()
	defer ps.lock.Unlock()
	ps.messages = append(ps.messages, msg)
	fmt.Println("Published:", msg)
}

func (ps *PubSub) subscribe(id int) {
	for {
		ps.lock.Lock()
		if len(ps.messages) > 0 {
			fmt.Printf("Subscriber %d received: %s\n", id, ps.messages[0])
			ps.messages = ps.messages[1:]
		}
		ps.lock.Unlock()
		time.Sleep(500 * time.Millisecond)
	}
}

func pubsub() {
	ps := &PubSub{} //returns a pointer

	go ps.subscribe(1)
	go ps.subscribe(2)

	// Simulate publishing using anonymous function
	go func() {
		messages := []string{"Go rocks!", "Pub-sub without channels", "Still concurrent!"}
		for _, msg := range messages {
			ps.publish(msg)
			time.Sleep(2 * time.Second)
		}
	}()

	time.Sleep(5 * time.Second)
}
