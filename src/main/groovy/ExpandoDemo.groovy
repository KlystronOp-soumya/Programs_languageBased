import org.codehaus.groovy.runtime.InvokerHelper
import java.io.StringWriter ;
class ExpandoDemo extends Script{
 
    def run() {                                 
       // create a expando class -- expando class is more like a dynamic bean in Groovy
       def agent = new Expando() ;
       agent.agentNum = '1968951' ;
       agent.unit = '1.1' ;
       agent.commission = 5000.35 ;
       agent.email = "agent.company@companyDomain.com" ;
       //define a closure method
       agent.printInfo = { writer -> // StringWriter is not working
        writer.write( "Username: $agentNum")
        writer.write( ", email: $email")
       }
       
       def sw = new StringWriter() ;
        agent.printInfo(sw) ;
        sw.write(agent.email) ;
        println agent.agentNum ;
    }

    static void main(String[] args) {           
        InvokerHelper.runScript(ExpandoDemo, args)     
    }
}