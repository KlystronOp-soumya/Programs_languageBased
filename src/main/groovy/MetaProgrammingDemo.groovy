class Example {
   static void main(String[] args) {
      Student mst = new Student();
      mst.Name = "Joe";
      mst.ID = 1;
        
      println(mst.Name);
      println(mst.ID);

      mst.AddMarks(); // nothing happens even if this method is missing

      println(mst.invokeMethod("Soumya" , "This is groovy")) //invokes this method
   }
}

class Student implements GroovyInterceptable { //needs to implement this interface
   protected dynamicProps=[:]

   void setProperty(String pName,val) {
      dynamicProps[pName] = val
   }
   
   def getProperty(String pName) {
      dynamicProps[pName]
   } 

   

   def methodMissing(String name, def args) {         
      println "Missing method $name"
   }  
    /*
    def invokeMethod(String name, Object args) {
      return "called invokeMethod $name $args"
   }
   */