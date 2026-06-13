#ifndef SYSMON_H
#define SYSMON_H

#include <windows.h>
#include <psapi.h>

// Holds a snapshot of system memory state
typedef struct {
    DWORDLONG total_physical_mb;
    DWORDLONG available_physical_mb;
    DWORDLONG used_physical_mb;
    DWORD     load_percent;
} MemoryInfo;

// Holds information about the current running process
typedef struct {
    DWORD  pid;
    SIZE_T working_set_kb;
    SIZE_T peak_working_set_kb;
    DWORD  handle_count;
} ProcessInfo;

// Holds system uptime
typedef struct {
    DWORD days;
    DWORD hours;
    DWORD minutes;
    DWORD seconds;
} UptimeInfo;

// Function declarations
int      get_memory_info(MemoryInfo* out);
int      get_process_info(ProcessInfo* out);
int      get_uptime(UptimeInfo* out);
void     print_separator(const char* title);

#endif