#include <iostream>
#include <numeric>
#include <string>

template<typename T>
std::string join_array(const T* arr, std::size_t n, const std::string& delim) {
    if (n == 0) return "";
    return std::accumulate(arr + 1, arr + n, std::to_string(arr[0]),
        [&delim](const std::string& a, const T& b) {
            return a + delim + std::to_string(b);
        });
}

int main() {
    long long n = 5;
    long long arr[] = {100, 200, 300, 400, 500};
    std::string delim = " -> ";

    std::cout << join_array(arr, n, delim) << '\n';
}