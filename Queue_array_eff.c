#include<stdio.h>
#define maxCapacity 5

int queue[maxCapacity], front = -1, rear = -1, currSize = 0;

void enQueue(int data){
    if(currSize == maxCapacity)
        printf("\nMax Size reached can't do enqueue");
    else{
        if(front == -1){
            front = currSize = 0;
            rear = maxCapacity - 1;
        }
      
    //imagine scenario where enqueue is happening at last element of queue 
    //if some dequeue has happened then 0th element or others may be free
    //using % operation we can now enter at 0th or others positions here
    rear = (rear + 1)%maxCapacity; 
    queue[rear] = data; 
    currSize = currSize + 1;
    printf("%d Successfully Enqueued at array pos:%d\n", data,rear); 
   }
}
void deQueue(){
    if(currSize == 0)
        printf("\nNo elements, queue is empty can't dequeue");
    else{
        printf("\nDequeued : %d", queue[front]);
        
        int item = queue[front];
        front = (front + 1)%maxCapacity; 
        currSize = currSize - 1;
        
        printf("\n%d Successfully dequeued & changed front value which is: at pos:%d\n", item,front);
   }
}
void display(){
    if(rear == -1)
        printf("\nQueue was Empty!!!");
    else{
        int i;
        printf("\nQueue :\n");
        
        for(i=front; i<=rear; i++)
	        printf("%d ",queue[i]);
   }
}

int main()
{
    enQueue(2);//front: a[0], rear: a[0]
    enQueue(4);//front: a[0], rear: a[1]
    enQueue(6);//front: a[0], rear: a[2]
    enQueue(8);//front: a[0], rear: a[3]
   
    //front: a[0], rear: a[3]
    deQueue();//0th pos now empty, //front: a[1], rear: a[3]
    deQueue();//1st pos now empty, //front: a[2], rear: a[3]
    
    //note the explanation in the above image starts from here
    
    enQueue(10);//front: a[2], rear: a[4]
    
    //front: a[2], rear: a[4]
    
    //rear = (rear + 1)%maxCapacity;    a[rear] = data; 
    //rear = (4 + 1)%maxCapacity; i.e. rear = 5%5 = 0, thus,    a[0] = 12; 
    enQueue(12);//front: a[2], rear: a[0]
    enQueue(14);//front: a[2], rear: a[1]
    
    deQueue();//2nd pos now empty, front: a[3], rear: a[1]
     
    enQueue(14);//front: a[3], rear: a[2]
    
   return 0;
}