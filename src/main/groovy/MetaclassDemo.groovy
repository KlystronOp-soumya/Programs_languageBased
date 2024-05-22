class Example {
   static void main(String[] args) {
      Student mst = new Student();
      println mst.getName()
      mst.metaClass.setAttribute(mst, 'name', 'Mark') //changes private field value using the metaclass
      println mst.getName()
   } 
} 

class Student {
   private String name = "Joe";
	
   public String getName() {
      return this.name;
   } 
}