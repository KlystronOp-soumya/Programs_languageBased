/*
This program sorts a doubly linked list using merge sort algorithm
*/
#include <bits/stdc++.h>
using namespace std;
typedef struct Node
{
	int data;
	struct Node *prev_node ;
	struct Node *next_node ;
};

Node *split(Node *head);

// function to merge two linked lists
//merges using recursion
Node *merge_lists(Node *first_list, Node *second_list)
{
	// when the first list is empty
	if (!first_list)
		return second_list;

	// when the second node is empty
	if (!second_list)
		return first_list;

	// get the minimum value
	if (first_list->data < second_list->data)
	{
		first_list->next_node = merge_lists(first_list->next_node,second_list);
		first_list->next_node->prev_node = first_list;
		first_list->prev_node = NULL;
		return first_list;
	}
	else
	{
		second_list->next_node = merge_lists(first_list,second_list->next_node);
		second_list->next_node->prev_node = second_list;
		second_list->prev_node = NULL;
		return second_list;
	}
}

//  merge sort algo
Node *mergeSort(Node *head)
{
	if (!head || !head->next)
		return head;
	Node *second = split(head);

	// Recur for left and right halves
	head = mergeSort(head);
	second = mergeSort(second);

	// Merge the two sorted halves
	return merge_lists(head,second);
}


// insert at the begining
void insert(Node **head, int data)
{
	Node *temp = new Node();
	temp->data = data;
	temp->next = temp->prev = NULL;
	if (!(*head))
		(*head) = temp;
	else
	{
		temp->next = *head;
		(*head)->prev = temp;
		(*head) = temp;
	}
}


void print(Node *head)
{
	Node *temp = head;
	cout<<"Forward Traversal using next pointer\n";
	while (head)
	{
		cout << head->data << " ";
		temp = head;
		head = head->next;
	}

}

// 
void swap(int *val1, int *val2)
{
	int temp = *val1;
	*val1 = *val2;
	*val2 = temp;
}

// Split the list into two seperate lists
Node *split(Node *head)
{
	Node *fast = head,*slow = head;
	while (fast->next && fast->next->next)
	{
		fast = fast->next->next;
		slow = slow->next;
	}
	Node *temp = slow->next;
	slow->next = NULL;
	return temp;
}

int main(void)
{
	Node *head = NULL;
	insert(&head, 6);
	insert(&head, 30);
	insert(&head, 1);
	insert(&head, 5);
	insert(&head, 45);
	insert(&head, 13);
	head = mergeSort(head);
	cout << "Linked List after sorting\n";
	print(head);
	return 0;
}

