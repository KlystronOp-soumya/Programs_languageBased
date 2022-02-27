#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int switch_num;
    char option;
    printf("Enter your choice: ");
    scanf("%d",&switch_num);

    switch (switch_num)
    {
    case 1: printf("Enlightens a Bulb");//if(switch_num == 1)
        /* code */
        break;
    
    case 2:printf("switchs on the Fan");//if(switch_num == 2)
        break;
    
    case 3: 
      printf("Switches on a Tube ");
    break;

    case 4: printf("powers the socket");
    break;
    
    
    default: printf("Plz enter a valid key value");
        exit(0);//break;
    }

    return 0;
}
