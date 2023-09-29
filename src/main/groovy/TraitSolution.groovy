import org.codehaus.groovy.runtime.InvokerHelper
interface Salary
{
   void  displaySalary()
}

trait Employee implements Salary
{
  
    void displaySalary()
    {
    }

    void displayID()
    {
    }

}

class Company implements Employee
{
    def salary , EmployeeID

    Company(def salary , def EmployeeID)
    {
        this.salary = salary
        this.EmployeeID = EmployeeID
    }

    void displaySalary()
    {
        println this.salary*12
    }

    void displayID()
    {
        println this.EmployeeID
    }
}


        Scanner sc = new Scanner(System.in)
        print "Enter the info"
        int s = sc.nextInt()
        println "Enter the info"
        int i = sc.nextInt()
        def c = new Company(s,i)
        c.displaySalary()
        c.displayID()

   
    
