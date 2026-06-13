#include "sysmon.h"
#include <stdio.h>

/*
 * Queries Windows GlobalMemoryStatusEx API
 * which fills a MEMORYSTATUSEX structure directly from the kernel
 */
int get_memory_info(MemoryInfo* out) {
    MEMORYSTATUSEX mem;
    mem.dwLength = sizeof(MEMORYSTATUSEX);

    if (!GlobalMemoryStatusEx(&mem)) {
        return 0;   // returns 0 on failure
    }

    // Convert bytes to megabytes
    out->total_physical_mb = mem.ullTotalPhys / (1024 * 1024);
    out->available_physical_mb = mem.ullAvailPhys / (1024 * 1024);
    out->used_physical_mb = out->total_physical_mb
        - out->available_physical_mb;
    out->load_percent = mem.dwMemoryLoad;

    return 1;
}

/*
 * Queries the current process handle via GetCurrentProcess()
 * then asks the OS for memory counters via GetProcessMemoryInfo()
 * and handle count via GetProcessHandleCount()
 */
int get_process_info(ProcessInfo* out) {
    HANDLE hProcess = GetCurrentProcess();

    PROCESS_MEMORY_COUNTERS pmc;
    pmc.cb = sizeof(PROCESS_MEMORY_COUNTERS);

    if (!GetProcessMemoryInfo(hProcess, &pmc, sizeof(pmc))) {
        return 0;
    }

    out->pid = GetCurrentProcessId();
    out->working_set_kb = pmc.WorkingSetSize / 1024;
    out->peak_working_set_kb = pmc.PeakWorkingSetSize / 1024;

    if (!GetProcessHandleCount(hProcess, &out->handle_count)) {
        out->handle_count = 0;
    }

    return 1;
}

/*
 * GetTickCount64 returns milliseconds since system boot
 * directly from the Windows HAL (Hardware Abstraction Layer)
 * We convert it into human readable days/hours/minutes/seconds
 */
int get_uptime(UptimeInfo* out) {
    ULONGLONG ms = GetTickCount64();
    ULONGLONG seconds = ms / 1000;

    out->days = (DWORD)(seconds / 86400);
    out->hours = (DWORD)((seconds % 86400) / 3600);
    out->minutes = (DWORD)((seconds % 3600) / 60);
    out->seconds = (DWORD)(seconds % 60);

    return 1;
}

/*
 * Simple utility to print a titled separator line to stdout
 */
void print_separator(const char* title) {
    printf("\n========== %s ==========\n", title);
}