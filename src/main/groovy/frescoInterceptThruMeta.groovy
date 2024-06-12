//Enter your code here. Read input from STDIN. Print output to STDOUT
class Solution {
  public static void main(String[] args) {
      def emp = new Employee()
      emp.Name = 'Jane'
      emp.ID =3000
      emp.Experience = 1.4f;
      emp.display(emp.Name , emp.ID , emp.Experience) ;
   } 
}
 
class Employee {
    
    String Name ;
    int ID ;
    float Experience ;
    def invokeMethod(String name, Object args) {
        println "called invokeMethod $name $args"
        return "called invokeMethod $name $args"
    }
    
}