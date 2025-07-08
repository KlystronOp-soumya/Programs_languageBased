package main

import "fmt"

//map impl in Go lang
// Set represents a collection of unique strings
type Set map[string]struct{}

// NewSet creates and returns a new Set
func NewSet(items ...string) Set {
	s := Set{}
	for _, item := range items {
		s.Add(item)
	}
	return s
}

// Add inserts an item into the set
func (s Set) Add(item string) {
	s[item] = struct{}{}
}

// Remove deletes an item from the set
func (s Set) Remove(item string) {
	delete(s, item)
}

// Contains checks whether an item is in the set
func (s Set) Contains(item string) bool {
	_, exists := s[item]
	return exists
}

// Size returns the number of items in the set
func (s Set) Size() int {
	return len(s)
}

// List returns all items in the set as a slice
func (s Set) List() []string {
	keys := make([]string, 0, len(s))
	for key := range s {
		keys = append(keys, key)
	}
	return keys
}

func mapdemo() {
	mySet := NewSet("apple", "banana", "cherry")
	mySet.Add("date")
	mySet.Remove("banana")

	fmt.Println("Set contains 'apple':", mySet.Contains("apple"))
	fmt.Println("All items:", mySet.List())
	fmt.Println("Size of set:", mySet.Size())
}
