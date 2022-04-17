/*
Check a binary tree is balanced or not
calculate the left and right subtree hieghts 
the diffrence must be <=1
*/
#include<bits/stdc++.h>
using namespace std;
//structure
typedef struct node
{
    int data;
    struct node *left;
    struct node *right;
  /*   node(int x)
    {
        this->data=x;
        this->left=NULL;
        this->right=NULL;
    } */
}treeNode;

treeNode* create_tree(int data)
{
    treeNode* curr_node=new treeNode;
    curr_node->data=data;
    curr_node->left=NULL;
    curr_node->right=NULL;

    return(curr_node);
}
void preorder(treeNode* node_add)
{
    cout<<"called";
    if(node_add==NULL)
    return ; //base case
    cout<<node_add->data<<" ";
    preorder(node_add->left);
    preorder(node_add->right);
}

/* bool isBalancedTree(treeNode* root,int *curr_height)
{
   int left_height,right_height,l,r;
   left_height=right_height=l=r=0;
   if(root==NULL)
   {
       *curr_height=0;
      return 1; 
   }
   

   l=isBalancedTree(root->left,&left_height);
   r=isBalancedTree(root->right,&right_height);
   //calculate height
   *curr_height=max(left_height,right_height)+1;

   //check balanced
   if(abs(left_height-right_height)>=2)
    return 0;
else
{
    return l && r; //return true;
}

} */
void delete_tree(treeNode * root)//inorder delete
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
    int *h;
    *h=0;
    treeNode *root=NULL;//intitialization
  root=create_tree(1);//returns the address of the created node with the data 1
  //right child
  root->right=create_tree(2);//NULL is replaced by the address of the newly created node
  //left child
  root->left=create_tree(3);//NULL is replaced by the address of the newly created node
  //right subtree child
  root->right->right=create_tree(4);
  root->left->left=create_tree(5);
  root->left->left->left=create_tree(9);

  preorder(root);
  //cout<<"The tree is balanced::"<<isBalancedTree(root,h);
  delete_tree(root);
    return 0;
}
