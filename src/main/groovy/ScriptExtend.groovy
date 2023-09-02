import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script 
{ def run() 
{println("Hello World");
}
static void main(String[] args) {   
InvokerHelper.runScript(Main, args)  
  }
}