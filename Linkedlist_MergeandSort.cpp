/**
 * Merge and sort a linked list
 * 
 * 
*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    node *next_node_address;
}ListNode;
//function prototypes
ListNode* push(ListNode** head,int data); //push data
void sort_list(ListNode*head);//sorting
void merge_lists(ListNode**head1,ListNode*head2);//append at the end of the other
//void merge_sort_lists(ListNode)




