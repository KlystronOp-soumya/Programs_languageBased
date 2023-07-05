/*
A GroovyBean is a JavaBean defined in Groovy
In Groovy , working with bean is much easier than Java.

Groovy fasciltates working with beans in 3 ways
->Generating the accessor methods
-> Allowing simplified access to all JavaBeans including the GroovyBeans
->Simplifying registration of event handlers together with annotation that declares a property Bindable
*/

class BookBean
{
    String title
}

def groovyBook = new BookBean()
groovyBook.setTitle('Groovy In Action') //defined by groovy
println groovyBook.getTitle() //initialized automatically
groovyBook.title = 'Groovy for Dummies'
println groovyBook.title
