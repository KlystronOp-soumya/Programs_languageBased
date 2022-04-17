/*
TREE TRAVERSAL WITHOUT USING THE RECURSION

Store the address of each node in a stack then retrieve

*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *left;
    struct node *right;
}treeNode;

treeNode * create_node(int data)
{
    treeNode *node=new treeNode;
    node->data=data;
    node->left=NULL;
    node->right=NULL;

    return(node);
}

void inorder(treeNode * root)
{
    stack<treeNode *> node_add;
    treeNode *curr_node=root;//address of the root store
    while(curr_node != NULL || node_add.empty()==false)
    {
        //cout<<"starting-data::"<<curr_node->data<<endl;
       //traverse left most node
       while(curr_node != NULL)
       {
          // cout<<"address of the element is inserted::"<<curr_node->data<<endl;
           //store the current address inside the stack
           node_add.push(curr_node);
           curr_node=curr_node->left;//pointing to next left child node address
       }
       //here the curr_node is node
       //replace it with the last valid node address
       curr_node=node_add.top();
       //remove the top node address
       node_add.pop();
       cout<<curr_node->data<<" ";
       curr_node=curr_node->right;
      // cout<<"right"<<endl;

    }
}



int main(int argc, char const *argv[])
{
    /* code */
    treeNode * root=NULL;
    root=create_node(0);
    root->left=create_node(1);
    root->right=create_node(2);
    root->left->left=create_node(3);
    root->left->right=create_node(4);
    root->left->left->left=create_node(5);
    root->right->left=create_node(6);
    root->right->right=create_node(7);
    inorder(root);
    return 0;
}

