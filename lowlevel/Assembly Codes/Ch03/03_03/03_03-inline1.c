#include <stdio.h>
/*
All the C variables used in the inline assembly must be external or global
The inline assembly keyword asm has been deprecated. The best way is to wrtie asm module and link these
*/
int total;

int main()
{
	int x;

	total = 1;
	for( x=0; x<10; x++ )
	{
		printf("%d\n",total);
		asm(
				".intel_syntax noprefix;"
				"mov rax, total;"
				"imul rax, 2;"
				"mov total,rax;"
		   );
	}

	return(0);
}
