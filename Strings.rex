/* Main program */ 
a = "Hello World" 
say left(a,5) /*SLicing shows 5 chars from left*/
say right(a,5) /*SLicing shows 5 chars from right*/
say length(a) 
say reverse(a)
say compare(a,b)
say copies(a,3) /*copies the same string for 3 times 
/*substr(string1,index,count) This method returns the position of one string within another. */
a = "Hello World" 
say pos("Hello",a)
say substr(a,2,3) 

/*This method returns the string after deletion of the characters post the count of characters.*/
say delstr(a,6)
