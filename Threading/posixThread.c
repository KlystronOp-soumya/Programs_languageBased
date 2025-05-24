#include <pthread.h>
#include <stdio.h>
#include <unistd.h> // For sleep function

// Function executed by the first thread
void* ThreadFunction1(void* arg) {
    for (int i = 0; i < 5; i++) {
        printf("Thread 1: Count %d\n", i + 1);
        sleep(1); // Sleep for 1 second
    }
    return NULL;
}

// Function executed by the second thread
void* ThreadFunction2(void* arg) {
    for (int i = 0; i < 5; i++) {
        printf("Thread 2: Count %d\n", i + 1);
        sleep(1); // Sleep for 1 second
    }
    return NULL;
}

int main() {
    pthread_t thread1, thread2;

    // Create the first thread
    pthread_create(&thread1, NULL, ThreadFunction1, NULL);

    // Create the second thread
    pthread_create(&thread2, NULL, ThreadFunction2, NULL);

    // Wait for both threads to complete
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("Both threads have completed.\n");

    return 0;
}