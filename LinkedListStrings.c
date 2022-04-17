#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct List_node
{
    char name[50];
    struct List_node *next_node_address;
}node;

void *append_node(node *head)
{
    node *temp, *r ;
    if(head ==  NULL)
     {
         fflush(stdin);
        temp=(node *) malloc(sizeof(node));
        printf("Enter Name: ");
        gets(temp->name);
        temp->next_node_address = NULL;
        head = temp;
     }
     else
     {
         temp = head;
          //trvaerse
          while(temp->next_node_address!= NULL)
           temp = temp->next_node_address ; 

         r =   (node *) malloc(sizeof(node));
         fflush(stdin);
         printf("Enter Name: ");
         gets(r->name);
         r->next_node_address = NULL;
         temp->next_node_address= r;
     }
  return head;
}

void display(node *head)
{
    node *temp = head;

    while(temp)
    {
        //fflush(stdout);
        puts(temp->name);
        temp = temp->next_node_address ;
    }
}

void delete(node **head)
{
    node *temp = *head,*old_node;
    old_node=temp;
    int flag = 0;
    char *str;
    str = (char *) malloc(sizeof(char)*50) ;
    printf("Enter the name to search : ");
    
    scanf("%s",str);

//if first node
if(strcmp(temp->name,str) == 0)
{
    temp = temp->next_node_address ;
    *head = temp;
    flag= 1;
    free(old_node);
}
else{
    while(temp)
    {
        if(strcmp(temp->name,str) == 0)
        {
            old_node->next_node_address =  temp->next_node_address ;
            free(temp);
            return ;
        }
        old_node = temp;
        temp=temp->next_node_address ;
    }
}

/* while(temp!=NULL)
   {
       //check for the value
       if(strcmp(temp->name,str)==0)
       {
           
           //if first node
           if(temp==*head)
             *head=(*head)->next_node_address;
           else
             {
                 old_node->next_node_address=temp->next_node_address;
                 
             }
             free(temp);
             return;
       }
       else
       {
           old_node=temp;
           temp=temp->next_node_address;
       }
       
   }*/
}

void dealloc(node * head)
{
    while(head!=NULL)
    {
        node *temp=head;
        head = head->next_node_address ;
        free(temp);
    }
    free(head);
}
int main(int argc, char const *argv[])
{
    /* code */
    node *head;
    head = NULL ;
    for(int i =0 ;i<3;++i)
    {
        head = append_node(head);

    }
    display(head);
    delete(&head);
    display(head);
    dealloc(head);
    return 0;
}
