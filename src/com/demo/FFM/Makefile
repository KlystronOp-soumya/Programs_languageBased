CC = gcc
CFLAGS = -Wall -Wextra
DLL = two_point_distance.dll
SRC = two_dimensional_point.c

all: $(DLL)

$(DLL): $(SRC)
	$(CC) $(CFLAGS) -shared -o $(DLL) $(SRC)
clean:
	rm *.dll