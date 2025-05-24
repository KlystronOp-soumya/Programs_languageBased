#include <windows.h>
#include <stdio.h>

// Function executed by the first thread
DWORD WINAPI ThreadFunction1(LPVOID lpParam) {
    for (int i = 0; i < 5; i++) {
        printf("Thread 1: Count %d\n", i + 1);
        Sleep(1000); // Sleep for 1 second
    }
    return 0;
}

// Function executed by the second thread
DWORD WINAPI ThreadFunction2(LPVOID lpParam) {
    for (int i = 0; i < 5; i++) {
        printf("Thread 2: Count %d\n", i + 1);
        Sleep(1000); // Sleep for 1 second
    }
    return 0;
}

int main() {
    HANDLE thread1, thread2;

    // Create the first thread
    thread1 = CreateThread(
        NULL,          // Default security attributes
        0,             // Default stack size
        ThreadFunction1, // Thread function
        NULL,          // Parameter to the thread function
        0,             // Default creation flags
        NULL           // Thread identifier
    );

    // Create the second thread
    thread2 = CreateThread(
        NULL,          // Default security attributes
        0,             // Default stack size
        ThreadFunction2, // Thread function
        NULL,          // Parameter to the thread function
        0,             // Default creation flags
        NULL           // Thread identifier
    );

    // Wait for both threads to complete
    WaitForSingleObject(thread1, INFINITE);
    WaitForSingleObject(thread2, INFINITE);

    // Close thread handles
    CloseHandle(thread1);
    CloseHandle(thread2);

    printf("Both threads have completed.\n");

    return 0;
}