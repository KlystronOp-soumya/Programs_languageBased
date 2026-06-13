#include <stdio.h>
#include <stdlib.h>
#include "sysmon.h"

int main(void) {
    printf("╔══════════════════════════════╗\n");
    printf("║     SYSTEM MONITOR  v1.0     ║\n");
    printf("╚══════════════════════════════╝\n");

    // ── Memory ──────────────────────────────────────────
    print_separator("MEMORY");

    MemoryInfo mem;
    if (get_memory_info(&mem)) {
        printf("  Total Physical RAM : %llu MB\n", mem.total_physical_mb);
        printf("  Used               : %llu MB\n", mem.used_physical_mb);
        printf("  Available          : %llu MB\n", mem.available_physical_mb);
        printf("  Memory Load        : %lu%%\n", mem.load_percent);

        // Draw a simple ASCII usage bar
        printf("  Usage  [");
        int filled = mem.load_percent / 5;   // 20 segments = 100%
        for (int i = 0; i < 20; i++)
            printf(i < filled ? "█" : "░");
        printf("] %lu%%\n", mem.load_percent);
    }
    else {
        printf("  ERROR: Could not query memory info.\n");
    }

    // ── Process ─────────────────────────────────────────
    print_separator("THIS PROCESS");

    ProcessInfo proc;
    if (get_process_info(&proc)) {
        printf("  PID                : %lu\n", proc.pid);
        printf("  Working Set        : %zu KB\n", proc.working_set_kb);
        printf("  Peak Working Set   : %zu KB\n", proc.peak_working_set_kb);
        printf("  Handle Count       : %lu\n", proc.handle_count);
    }
    else {
        printf("  ERROR: Could not query process info.\n");
    }

    // ── Uptime ──────────────────────────────────────────
    print_separator("SYSTEM UPTIME");

    UptimeInfo up;
    if (get_uptime(&up)) {
        printf("  Uptime : %u days  %02u:%02u:%02u\n",
            up.days, up.hours, up.minutes, up.seconds);
    }
    else {
        printf("  ERROR: Could not query uptime.\n");
    }

    printf("\n");
    return 0;
}