/* To delete a tree traverse the tree in any order and free the node*/
#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
    int data;
    struct node *left;
    struct node *right;
}tree_node;

//node creation
tree_node * create_node(int data)
{
  tree_node *node= new tree_node;
  node->data=data;
  node->left=NULL;
  node->right=NULL;
  return node;
}
void inorder(tree_node * root)
{
    if(root==NULL)
    return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}
void delete_tree(tree_node * root)
{
    //traverse Inorder
    if(root == NULL)
    return;
    delete_tree(root->left);
    cout<<"deleting::"<<root->data<<endl;
    delete_tree(root->right);
    delete root;

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
    delete_tree(root);
    return 0;
}
