# =========================
# Compiler & Flags
# =========================
CC       := gcc
CFLAGS   := -Wall -Wextra -Werror -std=c11 -O2
INCLUDES := -Iinclude

# =========================
# Directories
# =========================
SRC_DIRS := app lib
BUILD_DIR := build

# =========================
# Source & Object Files
# =========================
SRCS := $(wildcard app/*.c) $(wildcard lib/*.c)
OBJS := $(patsubst %.c,$(BUILD_DIR)/%.o,$(SRCS))
DEPS := $(OBJS:.o=.d)

TARGET := $(BUILD_DIR)/myproject.exe

# =========================
# Default Target
# =========================
all: $(TARGET)

# =========================
# Link
# =========================
$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $@

# =========================
# Compile Rule
# =========================
$(BUILD_DIR)/%.o: %.c
	@mkdir -p $(dir $@) 2>nul || exit 0
	$(CC) $(CFLAGS) $(INCLUDES) -MMD -MP -c $< -o $@

# =========================
# Dependency Include
# =========================
-include $(DEPS)

# =========================
# Clean
# =========================
clean:
	del /Q /S build\*.o build\*.d build\*.exe 2>nul || exit 0

# =========================
# Phony Targets
# =========================
.PHONY: all clean