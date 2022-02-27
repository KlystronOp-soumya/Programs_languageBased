//Billing Management System
#include<stdio.h>
#include<conio.h>
#include<ctype.h>
#include<windows.h>
#include<stdlib.h>

#define CLEANUP(f) (remove(f))
struct subscriber
{
char phoneNum[20];
char fullname[50];
float amounts;
}s;

void adding_records();
void listing_records();
void edit_records();
void remove_records();
void searching_records();
void payment_records();
char get;


void main(){ 
    int pass;
    int phoneNum;
    char options;

system("cls");
    printf("\n\t\t\t  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    printf("\n\t\t\t  +      ++++++++++++++++++++++++++++++++++++++++++++++++      +");
    printf("\n\t\t\t  +      +          BILLING MANAGEMENT SYSTEM           +      +");
    printf("\n\t\t\t  +      ++++++++++++++++++++++++++++++++++++++++++++++++      +");
    printf("\n\t\t\t  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

    printf("\n\t\t\t  PRESS ANY KEY TO CONTINUE");
    Sleep(2000);
    getch();
    while (1)
    {
        printf("\n\t\t\t\t FEATURE OF TELECOM BILLING\n\t\t\t\t  _____________________________________________");

        printf("\n\t\t\t\t| [A] ADDING NEW RECORDS                       |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [L] LIST OF RECORDS                          |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [M] MODIFY RECORDS                             |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [P] PAYMENT                                  |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [S] SEARCHING RECORDS                        |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [D] DELETING RECORDS                         |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [R] RESET ALL                                |");
        printf("\n\t\t\t\t| _____________________________________________|");

        printf("\n\t\t\t\t| [E] EXIT                                     |\n\t\t\t\t| _____________________________________________|\n\t\t\t\t\t\t\t\t");


        printf("\n\t\t\t\tPLEASE CHOOSE A NUMBER IN THE BOX ABOVE:");
        options=getche();
        options=toupper(options);
        switch(options)
        {
            case 'E':
                system("cls");
                printf("\n\n\t\t\t\tTHANK YOU");
                printf(":\tFOR USING OUR SERVICE");
                Sleep(2000);
                exit(0);
                break;
            case 'A':
                adding_records();
                break;
            case 'L':
                listing_records();
                break;
            case 'M':
                edit_records();
                break;
            case 'P':
                payment_records();
                break;
            case 'S':
                searching_records();
                break;
            case 'D':
                remove_records();
                break;
            case 'R':
                CLEANUP("file.txt");
                break;
            default:
                system("cls");
                printf("Incorrect Input");
                printf("\nAny key to continue");
                getch();
        }
    }
}

//ADD Record in the list
void adding_records()
{
    FILE *f;
    char test;
    f=fopen("file.txt","a+");
    if(f==0)
    {   
        f=fopen("file.txt","w+");
        system("cls");
        printf("/nPlease wait while we configure your computer");
        printf("/nPress any key to continue");
        getch();
    }
    
    while(1){
        system("cls");
        printf("\n--------------------\n");
    	printf("Add New Record");
		printf("\n--------------------\n");
        printf("\n Enter phone number:");
        scanf("%s",&s.phoneNum);
        printf("\n Enter name:");
        fflush(stdin);
        scanf("%[^\n]",&s.fullname);
        printf("\n Enter amount:");
        scanf("%f",&s.amounts);
        fwrite(&s,sizeof(s),1,f);
        fflush(stdin);
        printf("\n------------------------------------------------------------------");
        printf("\n1 Record successfully added. Please wait...");
        Sleep(3000);
        system("cls");
        printf("\n Press esc key to exit, any other key to add other record:");
        test=getche();
        if(test==27)
            break;
        }
        system("cls");
        fclose(f);
    }

//Listing Records
void listing_records()
{
    
	FILE *f;
    int i;
    if((f=fopen("file.txt","r"))==NULL)

        exit(0);
        system("cls");
        printf("Phone Number\t\tUser Name\t\t\tAmount\n");
        for(i=0;i<79;i++)
            printf("-");
        while(fread(&s,sizeof(s),1,f)==1)
        {
            printf("\n%-10s\t\t%-20s\t\t%.2f /-",s.phoneNum,s.fullname,s.amounts);
        }
        printf("\n");
        for(i=0;i<79;i++){
            printf("-");
        }
    fclose(f);
    printf("\nPress any key to continue..");
    getch();
    system("cls");
    
}

//Delete Record
void remove_records(){
    FILE *f, *t;
    char phoneNum[20];
    get = 'y';
    system("cls");
    f=fopen("file.txt","r");
    t=fopen("temp.txt", "w");
    while(get=='y' || get=='Y'){
    	rewind(f);
        printf("Enter the phone number to be deleted from the Database : ");
        scanf("%s",phoneNum);
        while(fread(&s,sizeof(s),1,f)==1)
        {
           if(strcmp(s.phoneNum,phoneNum)!=0)
            {       
                fwrite(&s,sizeof(s),1,t);
            }
            else{
                printf("\nRecord Deleted Successfully!!!");
            }
        }
        fclose(f);
        fclose(t);
        remove("file.txt");
        rename("temp.txt","file.txt");
        printf("\nDo you want to delete another record (y/n): ");
        fflush(stdin);
        scanf("%c", &get);      
        if(get=='y' || get=='Y'){
        	f=fopen("file.txt", "r");
        	t=fopen("temp.txt", "w");
		}
		else{
			printf("\nReturning to main menu shortly....");
			Sleep(2000);
			break;			
		}
	}
	system("cls");   
}

//Search Record
void searching_records()
{
    FILE *f;
    char phoneNum[20];
    int flag=1;
    f=fopen("file.txt","r+");
    if(f==0)
        exit(0);
        fflush(stdin);
        system("cls");
        printf("Enter Phone Number to search in our database : ");
        scanf("%s", phoneNum);
        while(fread(&s,sizeof(s),1,f)==1)
        {
            if(strcmp(s.phoneNum,phoneNum)==0){ 
                system("cls");
                printf("--------------");
                printf("\n Record Found\n");
                printf("--------------");
                printf("\n\nPhonenumber: %s\nName: %s\nAmount: %0.2f\n",s.phoneNum,s.fullname,s.amounts);
                flag=0;
                break;
            }
            else if(flag==1){ 
                system("cls");
                printf("Requested Phone Number Not found in our database");
            }
        }
        printf("\nPress any key to continue to main menu...");
        getch();
        fclose(f);
        system("cls");
}

//Modify Record
void edit_records()
{
    FILE *f;
    char phoneNum[20];
    long int size=sizeof(s);
    if((f=fopen("file.txt","r+"))==NULL)
        exit(0);    
        system("cls");
        printf("Enter phone number of the subscriber to modify:");
        scanf("%s",phoneNum);
        fflush(stdin);
        while(fread(&s,sizeof(s),1,f)==1){
            if(strcmp(s.phoneNum,phoneNum)==0){
                system("cls");
                printf("\n-------------------------------\n");
                printf("Data found successfully.");
                printf("\n-------------------------------\n");
                printf("\nPlease modify and re-enter the data...");
                printf("\n Enter phone number:");
                scanf("%s",&s.phoneNum);
                printf("\n Enter Name: ");
                fflush(stdin);
                scanf("%[^\n]",&s.fullname);
                printf("\n Enter amount: ");
                scanf("%f",&s.amounts);
                fseek(f,-size,SEEK_CUR);
                fwrite(&s,sizeof(s),1,f);
                break;
            }
        }
        fclose(f);
        printf("\nRecord Modified Successfully.");
        printf("\nPress any key to continue to main menu...");
        getch();
        system("cls");
}

//View Payment and Payment
void payment_records(){
    FILE *f;
    struct subscriber sub;
    char phoneNum[20];
    long int size=sizeof(s);
    float amt;
    int i;
    if((f=fopen("file.txt","r+"))==NULL)
        exit(0);
        system("cls");
        printf("Enter phone number of the subscriber for payment : ");
        scanf("%s",phoneNum);
        fflush(stdin);
        int flag = 0;
        while(fread(&sub,sizeof(s),1,f)==1)
        {
            if(strcmp(sub.phoneNum,phoneNum)==0){
                printf("\n Phone No.: %s",sub.phoneNum);
                printf("\n Name: %s",sub.fullname);
                printf("\n Current amount: %f",sub.amounts);
                printf("\n");
                for(i=0;i<79;i++)
                    printf("-");
                printf("\n\nEnter amount of payment :");
                fflush(stdin);
                scanf(" %f",&amt);
                sub.amounts= sub.amounts-amt;
                fseek(f,-size,SEEK_CUR);
                fwrite(&sub,sizeof(sub),1,f);
                flag = 1;
                break;
            }
        }
        if(!flag){
            printf("\nRecord not found.");
            Sleep(1000);
            fclose(f);
            return;
        }
        if(sub.amounts == 0){
            printf("THANK YOU %s FOR YOUR TIMELY PAYMENTS",sub.fullname);
        }   
        else{
            printf("\nDue amount is %f. Please pay amount soon.",sub.amounts);
            Sleep(1000);
        }
	printf("\nPress any key to continue to main menu...");   
    getch();
    fclose(f);
    system("cls");
}

