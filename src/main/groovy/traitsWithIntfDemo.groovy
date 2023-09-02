import org.codehaus.groovy.runtime.InvokerHelper
interface Total
{
   void totalMarks()
}

trait result implements Total{
    int result;

   void displayResult()
    {
        this.result=10
        println "Result is ${this.result}"
    }

    void totalMarks()
    {
        println 'Total marks in percent: ' + this.result/100 ;
    }
}

class Student implements result
{
    int marksId ;
}

def student = new Student()
student.setMarksId(1001)
println student.getMarksId()
println student.displayResult()
println student.totalMarks()

/*class Example extends Script{

    def run()
    {
        println 'Running this script'
        def student=new Student()
        student.setMarksId(1001) ;
        println student.getMarksId()
    }

    static main(args) {
        InvokerHelper.runScript(Example , args)
        
    }
}*/