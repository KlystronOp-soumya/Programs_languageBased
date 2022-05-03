#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
int main(int argc, char const *argv[])
{
    FILE *fp;

    fp=fopen("EmployeeData.txt","r");
    int e = (fp==0)?1:0;

    printf("The file exists: %d",e);
     if(remove(fp))
      printf("deleted");
    else
     printf("not delted");
    return 0;
}
