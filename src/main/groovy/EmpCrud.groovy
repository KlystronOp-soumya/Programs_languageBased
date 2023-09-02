@GrabConfig( systemClassLoader=true )
@Grab('com.mysql:mysql-connector-j:8.0.31')
import java.sql.*; 
import groovy.sql.Sql 
import org.codehaus.groovy.runtime.InvokerHelper
class EmployeeCrudDemo extends Script{

    def run()
    {
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/HIBJPATEST', 
         'Soumya', 'system', 'com.mysql.cj.jdbc.Driver')
			
      // Executing the query SELECT VERSION which gets the version of the database
      // Also using the eachROW method to fetch the result from the database
   
      sql.eachRow('SELECT VERSION()'){ row ->
         println row[0]
      }
		
      sql.close()  
    }

    static main(args) {
       InvokerHelper.runScript(EmployeeCrudDemo , args) 
    }

}
