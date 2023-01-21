/*
Segregate students into groups accroding to their marks
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

#define COUNT 10

void count_groups(int *groups,double *student_marks )
{
    for(int  i =0 ;i<COUNT ;++i)
    {
       if(student_marks[i]== 100)
       {
         groups[9]++;
       }
       else if(student_marks[i]>=0 && student_marks[i] <=10)
       {
            groups[0]++;
       }
       else
        {
             groups[(int)student_marks[i]/10]++;
        }
    
    }
    printf("0-9:%d\n10-19:%d\n20-29:%d\n30-39:%d\n40-49:%d\n50-59:%d\n60-69:%d\n70-79:%d\n80-89:%d\n90-100:%d\n"
    ,groups[0],groups[1],groups[2],groups[3],groups[4],groups[5],groups[6],groups[7],groups[8],groups[9]);
   /*  for(int i =0;i<COUNT;++i)
    {
       printf("%2d ",groups[i]);
    } */
} 
 
int main(int argc,char*argv[])
{
  unsigned int groups[COUNT];
  memset(groups,0,COUNT*sizeof(int));//initializing with 0
  double  student_marks[COUNT];
 for(int  i  = 0;i<COUNT ;++i)
{
    scanf("%lf",&student_marks[i]);
}
 
 count_groups(groups,student_marks);
return 0;
}