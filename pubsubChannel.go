package main

import (
	"fmt"
	"time"
)

// Publisher sends messages to a channel
func publisher(topic chan string) {
	messages := []string{"Hello!", "Welcome to pub-sub", "Goroutines are fun!"}
	for _, msg := range messages {
		fmt.Println("Publishing:", msg)
		topic <- msg
		time.Sleep(1 * time.Second)
	}
	close(topic) // Close channel after publishing
}

// Subscriber receives messages from a channel
func subscriber(id int, topic chan string) {
	for msg := range topic {
		fmt.Printf("Subscriber %d received: %s\n", id, msg)
	}
}

func pubsubChannel() {
	topic := make(chan string)

	// Start the subscriber
	go subscriber(1, topic)

	// Start the publisher
	go publisher(topic)

	// Wait for goroutines to finish
	time.Sleep(5 * time.Second)
}
