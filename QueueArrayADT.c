//Implementation of queue using the array
#include <stdio.h>
#include <stdlib.h>

void enqueue(int *, int *, int *, int);
void dequeue(int *, int *, int *);
void display(int *, int *, int *);

int main(int argc, char const *argv[])
{
    int n;
    printf("Enter the number of elements in the queue:");
    scanf("%d", &n);
    //intialize
    int *queue;
    queue = (int *)malloc(sizeof(int) * n);
    int front = -1, rear = -1;
    for (int i = 0; i <= 10; ++i)
    {
        enqueue(queue, &front, &rear, i);
        //debug
        printf("After insertion: front=%d rear=%d\n", front, rear);
    }
    printf("Dequeing:");
    dequeue(queue, &front, &rear);
    printf("After deletion: front=%d rear=%d\n", front, rear);
    display(queue, &front, &rear);
    dequeue(queue, &front, &rear);
    printf("After deletion: front=%d rear=%d\n", front, rear);
    display(queue, &front, &rear);

    free(queue);
}
void enqueue(int *queue, int *f, int *r, int val)
{
    int temp_f, temp_r;
    //temporarily storing the the index pointer
    temp_f = *f;
    temp_r = *r;
    if (*r > 11)
    {
        printf("Queue Full");
        exit(1);
    }
    if (temp_f == -1 && temp_r == -1)
    {
        temp_f++;
        queue[temp_f] = val;
        temp_r++;
    }
    else
    {
        //increase the rear
        temp_r++;
        queue[temp_r] = val;
    }
    //update the locations
    *f = temp_f;
    *r = temp_r;
}

void dequeue(int *queue, int *f, int *r)
{
    int temp_f, temp_r;
    //storing the current value
    temp_f = *f;
    temp_r = *r;
    int item;
    if (temp_f == -1 && temp_r == -1)
    {
        printf("Queue is empty");
        exit(1);
    }
    else if (temp_f == temp_r)
    {
        item = queue[temp_f];
        temp_f--;
        temp_r--;
    }
    else
    {
        item = queue[temp_f];
        temp_f++;
    }
    *f = temp_f;
    *r = temp_r;
    printf("Dsicarded element: %d\n", item);
}
void display(int *queue, int *f, int *r)
{
    int temp_f, temp_r;
    temp_f = *f;
    temp_r = *r;

    while (temp_r >= temp_f)
    {
        printf("%d ", queue[temp_r]);
        temp_r--;
    }
    printf("\n");
}