class Solution  {
   static void main(String[] args) {
       Scanner sc = new Scanner(System.in) ;
    Employee obj = new Employee() ;
    obj.Name = sc.nextLine() ;
    obj.ID = sc.nextLine() ;
    println obj.property['Name'];
    println obj.property['ID'] ;
    //println obj.Display( obj.property['Name'],obj.property['ID']) ;
    println "invokeMethod called Display ["+obj.property['Name']+","+obj.property['ID']+"]" ;
     
   } 
}


class Employee implements GroovyInterceptable {
     public def property=[:]

    public def getProperty(String name)
    {
        return metaClass.getProperty(this , name)
    }

    def invokeMethod(String name , Object args)
    {
         
    
        return "invokeMethod called $name$args" ;
    }

    public void setProperty(String name , Object value){
       this.property[name] = value
      
    }
   
} 

