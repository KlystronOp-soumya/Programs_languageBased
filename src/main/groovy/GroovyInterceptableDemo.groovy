/*
This script demostrates the Groovy MOP and Interceptable demo
this interface extends GroovyObject
*/
import  groovy.lang.GroovyInterceptable ;
import org.codehaus.groovy.runtime.InvokerHelper ;

class GroovyInterceptableDemo extends Script {

   def run() {                                 
            EmployeeInterceptable emp = new EmployeeInterceptable() ;
             
            //emp.property = 'a'

            println emp.property ;

            //emp.property = 'hello' ;

            println emp.property ;
    }   
    static void main(String[] args) {           
        InvokerHelper.runScript(GroovyInterceptableDemo, args)     
    }
}


class EmployeeInterceptable implements GroovyInterceptable {

    String property = 'b'
    /*
    void setProperty(String name, Object value) {
       
        this.@"$name" = 'w'
    }*/
    
    def getProperty(String name) {
            if(name != 'hello')
                return metaClass.getProperty(this, name)
            else
                return 'world' ;  
      
    }
     def invokeMethod(String name, Object args) {
        return "called invokeMethod $name $args"
    }
}

class Employee extends EmployeeInterceptable{
    
}