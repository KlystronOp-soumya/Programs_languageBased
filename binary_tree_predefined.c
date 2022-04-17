/*The program implements the Binary tree
from array
*/
#include<stdio.h>
#include<stdlib.h>

typedef struct tree_node
{
    char data;
    struct tree_node *left,*right;
}node;

char nodes[]={'A','B','C','D','E','F','G','\0','\0','H'};
int lc[]={1,3,5,-1,9,-1,-1,-1,-1,-1};
int rc[]={2,4,6,-1,-1,-1,-1,-1,-1,-1};


node* buildtree(int index)
{
    node *newnode=NULL;
    //base case
    if(index==-1)
     return NULL;
      
    else
    {
        //new node created and address is stored at the newnode pointer
        newnode=(node*)malloc(sizeof(node));
        //recursive call for left child
        //printf("index=%d nodes=%c lc[%d]=%d rc[%d]=%d\n",index,nodes[index],index,lc[index],index,rc[index]);
        newnode->data=nodes[index];
        newnode->left=buildtree(lc[index]);
        newnode->right=buildtree(rc[index]);
   }
   return newnode;
    
}
void Inorder(node *root)
{
   if(root==NULL) //base case
     return;
   else
   {
       Inorder(root->left);
       printf("%c ",root->data);
       Inorder(root->right);
   }
   return;
}
 void Preorder(node *root)
{
    if(root==NULL) //base case
     return;
   else
   {
       printf("%c ",root->data);
       Inorder(root->left);
       
       Inorder(root->right);
   }
   return;
} 
 void Postorder(node *root)
{
    if(root==NULL) //base case
     return;
   else
   {
     
       Inorder(root->left);
       
       Inorder(root->right);  
       printf("%c ",root->data);
   }
   return;
} 

int main(int argc, char const *argv[])
{
    //initializaion
    node * root=NULL;
    //call
    root=buildtree(0);//index of root element
    printf("Inorder traversal is: ");
    Inorder(root);
    printf("\n");//address of  the root node
    printf("Preorder traversal is: ");
    Preorder(root);
    printf("\n");//address of  the root node
    printf("Postorder traversal is: ");
    Postorder(root);//address of  the root node
    return 0;
}
