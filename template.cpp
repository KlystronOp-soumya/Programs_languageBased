#pragma GCC optimize("O3,unroll-loops")
#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <array>
#include <deque>
#include <list>
#include <forward_list>
#include <stack>
#include <queue>
#include <set>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <numeric>
#include <iterator>
#include <ranges>
#include <functional>
#include <utility>
#include <tuple>
#include <bitset>
#include <optional>
#include <variant>
#include <any>
#include <span>
#include <chrono>
#include <random>
#include <memory>
#include <type_traits>
#include <concepts>
#include <format>       // C++23
#include <compare>      // C++20
#include <execution>    // For parallel algorithms
#include <cassert>
// g++ -std=c++23  -O2 -Wall -Wextra -pedantic .\template.cpp
int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::vector<int> v = {1, 2, 3, 4, 5};
    auto doubled = v | std::views::transform([](int x) { return x * 2; });

    for (int x : doubled) {
        std::cout << std::format("{} ", x);
    }
    std::cout << '\n';

    return 0;
}