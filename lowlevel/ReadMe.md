#### Description
This folder holds the excercise files from the LinkedIn course "Advanced C: Assembly language with C"
Check valgrind for code analysis

#### Tools:
<li>WSL with Ubuntu</li>
<li>NASM</li>
<li>CLANG</li>

##### How to
<p>Windows</p>

>nasm -f win64 .\01_03-goodbye.asm
<p>Linux</p>

>nasm -f elf64 .\01_03-goodbye.asm

<p>Link</p>

> ld 01_03-goodbye.o

<p>Execute is WSL2 + Ubuntu</p>

> ./a.out

<p>Assemble</p>

> nasm -f elf64  02_01-hello2.asm

<p>Dissamble</p>

> ndisasm -b 64 02_01-hello2.o or objdump -M intel -d 02_01-hello2.o


