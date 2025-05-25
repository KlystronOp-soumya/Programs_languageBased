/* include stdio.h isn't needed because
   the assembly module does the output */

/* you still must prototype the function */
void message(void);
// clang -c main.c to generate the object code
// then link these using the clang main.o message.o -o main
// ./main
int main()
{
	int x;

	for( x=0; x<5; x++ )
		message();//this is a assembly code module written in the message.asm

	return(0);
}
