/*
Program to check pattern or presence of SubString
*/
#pragma GCC optimize("Ofast")
#pragma pack(1)
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100
 
//function signatures
int substring(char* , char*);
void display();
 
int main(int argc,char*argv[])
{
 
 const char str1[]="Kolkata";
 const char str2[]="Kol";
    int pos=-1;
 //system("cls");
 pos=substring(str1,str2);

    if(pos!=-1)
     printf("FOUND");
    else
     printf("NOT FOUND");
return 0;
}

/*Brute Force algorithm to search the string*/
int substring(char * str1, char* str2)
{
    int flag = 1 ;
    int i,j,k;
    int len1= strlen(str1);
    int len2 = strlen(str2) ;

    for(i =0 ;i<=len1-len2; i++)//n
    {
        j=0;//each iteration resets j
        k=i;//k at ith position
        while(str1[k] == str2[j] && j<len2)//m
        {
            //increasing the indexes to match the next characters
            k++;
            j++;

        }
        if(j==len2)
             return i;
    
    }
    return -1;
}