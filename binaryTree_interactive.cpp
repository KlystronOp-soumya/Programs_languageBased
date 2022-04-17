#include<bits/stdc++.h>

using namespace std;

typedef struct node
{
    int data;
    struct node *left;
    struct node * right;
}treeNode;

treeNode* create_node(int data)
{
    //create node
    treeNode * root = new treeNode;
    root->data=data;
    root->left=NULL;
    root->right=NULL;
    return(root);
}

//traversal
void preorder(treeNode * currNode)
{
  //base condition
  if(currNode==NULL)
   return ;
  
  cout<<currNode->data;//root left right
  preorder(currNode->left);
  preorder(currNode->right);
}
int main()
{
    
  treeNode *root=NULL;//intitialization
  root=create_node(1);//returns the address of the created node with the data 1
  //right child
  root->right=create_node(2);//NULL is replaced by the address of the newly created node
  //left child
  root->left=create_node(3);//NULL is replaced by the address of the newly created node
  //right subtree child
  root->right->right=create_node(4);
  root->left->left=create_node(5);
  root->left->left->left=create_node(9);

  preorder(root);

  return 0;

}