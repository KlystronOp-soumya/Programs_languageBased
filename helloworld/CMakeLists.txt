cmake_minimum_required(VERSION 3.20)
project(helloworld VERSION 0.1.0 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(date CONFIG REQUIRED)

add_executable(helloworld src/main.cpp)

target_link_libraries(helloworld PRIVATE date::date date::date-tz)