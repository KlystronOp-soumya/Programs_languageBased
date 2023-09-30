/*
A method can also be used as a closure in groovy using
Reference.& operator
*/
class SizeFilter {
Integer limit
boolean sizeUpTo(def value)
{
return value.size() <= limit
}
}
SizeFilter filter6 = new SizeFilter(limit:6)
SizeFilter filter5= new SizeFilter(limit:5)
Closure sizeUpTo6 = filter6.&sizeUpTo
def words = [ 'short', 'tiny', 'medium', 'long tiny']
assert 'medium' == words.find (sizeUpTo6)
assert 'short' == words.find (filter5. sizeUpTo)