#pragma GCC optimize("O3,unroll-loops")
#include <bits/stdc++.h>
#include <chrono>
#include <date/date.h>
using namespace std;
using namespace std::chrono;
using namespace date;
#define deb(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "
constexpr char END_LINE = '\n';

int main(int argc, char *argv[])
{
    auto now = system_clock ::now();
    auto today = floor<days>(now);

    year_month_day ymd{today};

    auto time_of_day = make_time(now - today);

    std::cout << "Date: " << ymd << END_LINE;
    std::cout << "Time: " << time_of_day << END_LINE;

    auto birthday = year{1995} / month{6} / day{15};
    auto diff = sys_days{ymd} - sys_days{birthday};
    std::cout << "Days since 1995-06-15: " << diff.count() << "\n";

    return 0;
}