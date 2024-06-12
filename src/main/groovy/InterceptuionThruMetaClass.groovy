
    

 
class Employee {
    String name
    int id
    float experience

     def invokeMethod(String name, Object args) {
        return "called invokeMethod $name $args"
    }
}


      def emp = new Employee()
      emp.name ='John'
      emp.id = 13
      emp.experience = 3.2 ;
    
    println  emp.display("Hi" , "")