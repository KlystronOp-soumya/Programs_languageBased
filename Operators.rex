/* Main program*/ 
X = 40 
Y = 50 

Res1 = X + Y 
Res2 = X - Y 
Res3 = X * Y 
Res4 = X / Y 
Res5 = X % Y 
Res6 = X // Y 

say Res1 
say Res2 
say Res3 
say Res4 
say Res5 
say Res6 

/*Conditional Operators*/
/* Main program*/ 
X = 3 
Y = 2 

say X > Y 
say X < Y 
say X >= Y 
say X <= Y 
say X == Y

/*Logical Operators*/
say 1 & 0 /*Logical And*/ 
say 1 | 0 /*Logical OR*/
say 1 && 0 /*Logical XOR*/
say \1  /*Logical NOT*/

/*Logical Operators*/
/* Main program */ 
a = 21 
b = 347 

Say c2b(a) 
Say c2b(b) 
Say c2b(bitand(a,b)) /*Bit wise and*/
Say c2b(bitor(a,b)) /*OR*/
Say c2b(bitxor(a,b)) /*XOR*/
Exit 

c2b: return x2b(c2x(arg(1)))