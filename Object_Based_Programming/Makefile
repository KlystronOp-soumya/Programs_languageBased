# =========================
# Compiler & Flags
# =========================
CC       := gcc
CFLAGS   := -Wall -Wextra -Werror -std=c11 -O2
LDFLAGS  :=
TARGET   := myproject.exe

# =========================
# Source & Object Files
# =========================
SRCS     := main.c CoOrdinates.c
OBJS     := $(SRCS:.c=.o)
DEPS     := $(OBJS:.o=.d)

# =========================
# Default Target
# =========================
all: $(TARGET)

# =========================
# Link Step
# =========================
$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $@ $(LDFLAGS)

# =========================
# Compile Step (Pattern Rule)
# =========================
%.o: %.c
	$(CC) $(CFLAGS) -MMD -MP -c $< -o $@

# =========================
# Include Dependencies
# =========================
-include $(DEPS)

# =========================
# Clean
# =========================
clean:
	del /Q *.o *.d $(TARGET) 2>nul || exit 0

# =========================
# Phony Targets
# =========================
.PHONY: all clean