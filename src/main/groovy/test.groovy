class Test implements GroovyInterceptable {
    def property

    def getProperty(String name) {
        
        return property
    }

    void  setProperty(String name, value) {
        this.@"$name" = 'val'
    }

    def invokeMethod(String name, args) {
        println "Invoke method $name with args: $args"
    }
}

def test = new Test()
test.property = 'John'
println test.property

