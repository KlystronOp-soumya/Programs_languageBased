import groovy.transform.Immutable
@Immutable(defaults=true, noArg=false)
 class FixedBook
{
    String title
}

def gina = new FixedBook("Groovy In Action")
def regina = new FixedBook(title: 'This is Groovy')

assert gina.title == "Groovy In Action"
assert gina == regina

try
{
    gina.title = "Oops!"
    asser false , "Should not be here"
}catch(ReadOnlyPropertyException expected)
{
    println "Expected Error:'$expected.message'"
}