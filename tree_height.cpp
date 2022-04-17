/*
This program calculates the height of the tree.
root is always at 0 height
Recursively calculate the heigth and return the highest one
*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *left;
    struct node *right;
} tree_node;

tree_node * create_node(int data)
{
    tree_node * node = new tree_node;
    node->data=data;
    node->left=NULL;
    node->right=NULL;

    return(node);
}

void inorder(tree_node * root)
{
    //base condition
    if(root==NULL)
    return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}

int height(tree_node * root)
{
   //base
   if(root ==NULL)
   return 0;

   int left_subtree=height(root->left);
   int right_subtree=height(root->right);

   if(left_subtree>right_subtree)
   {
       cout<<left_subtree<<"&_if"<<right_subtree<<endl;
       return(left_subtree+1);
   }
     
   else
   {
        cout<<left_subtree<<"&"<<right_subtree<<endl;
      return (right_subtree+1);
   }
     
}
int main(int argc, char const *argv[])
{
    /* code */
    tree_node * root=NULL;
    root=create_node(0);
    root->left=create_node(1);
    root->right=create_node(2);
    root->left->left=create_node(3);
    root->left->right=create_node(4);
    root->left->left->left=create_node(5);
    root->right->left=create_node(6);
    root->right->right=create_node(7);

    inorder(root);
    cout<<endl;
     int ht=height(root);
    cout<<"Height::"<<ht; 

    return 0;
}
