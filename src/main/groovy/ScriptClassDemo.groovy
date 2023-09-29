import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script {
    def run() {
        println 'Groovy world!'
    }
    static void main(String[] args) {
        InvokerHelper.runScript(Main, args)
    }
}

"""
GroovyClassLoader loader = new GroovyClassLoader()
GroovyCodeSource codeSource = new GroovyCodeSource(script, "MyClass", GroovyShell.DEFAULT_CODE_BASE)
println loader.parseClass(codeSource)

"""