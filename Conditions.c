#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int res;
    char grade;
    printf("Enter the result: ");
    scanf("%d",&res);

    if(res >100)
     printf("invalid result");
     if (res >=90 && res <=100)
    {
        printf("Extra Ordinary Result");
        grade = 'E';
    }
     if ( res >=80 && res <=89)
    {
        printf("Great Result");
        grade = 'A';
    }
     if ( res >=70 && res <=79)
    {
        printf("Good Result");
        grade = 'B';
    }
     if ( res >=60 && res <=69)
    {
        printf("Better Result");
        grade = 'C';
    } 
     if ( res >=50 && res <=59)
    {
        printf("Fine Result");
        grade = 'D';
    }  
    /*  if ( res >=60 && res <=69)
    {
        printf("Better Result");
        grade = "B+";
    } */ 
    
    
     

    return 0;
}

