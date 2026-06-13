#### Execute the command

```bash
# This expands every #include and #define
gcc -E src/service.c -Iinclude -o service.i


gcc -E src/main.c -Iinclude -o main.i

# Compile service.t into assembly
gcc -S service.i -o service.s

gcc -S main.i -o main.s

# assemble into object file
gcc -c service.s -o service.o

gcc -c main.s -o main.o

# Link everything into final .exe
gcc main.o service.o -o sysmon.exe -lpsapi -lkernel32

```

#### Commands for inspection

```bash
# See how many lines the preprocessor generated
(Get-Content service.i).Count

# Peek at the assembly output
Get-Content service.s | Select-String "get_memory_info" -Context 0,10

(Get-Item service.o).length

objdump -t main.o | findstr -v "UND"

objdump -t service.o | findstr -v "UND"

```
