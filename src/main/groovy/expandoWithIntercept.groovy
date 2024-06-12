
//not working
import groovy.lang.GroovyInterceptable

class MyExpando extends Expando implements GroovyInterceptable {

    public void setProperty(String name , Object value){
       name = value ;
      
    }

    public def getProperty(String name)
    {
        return metaClass.getProperty(this , name)
    }

    def invokeMethod(String name, Object args) {
        println "Called method $name with args: $args"
        super.invokeMethod(name, args)
    }
}

def myExpando = new MyExpando()
myExpando.newProperty = "Hello, World!"
myExpando.newMethod = { println "This is a new method!" }

println myExpando.newProperty  // Outputs: Called method getProperty with args: [newProperty]
myExpando.newMethod()  // Outputs: Called method newMethod with args: []
