#include <iostream>
#include <queue>

class MyComparator {
    public:
        bool operator()(int a, int b) const {
            // Custom comparison logic (min heap)
            return a > b;
        }
};

int main() {
    std::priority_queue<int, std::vector<int>, MyComparator> minHeap; // this is a constructor
    minHeap.push(5);
    minHeap.push(2);
    minHeap.push(8);

    while (!minHeap.empty()) {
        std::cout << minHeap.top() << ' ';
        minHeap.pop();
    }


    return 0;
}
