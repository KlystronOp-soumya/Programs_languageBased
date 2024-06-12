import java.util.Scanner ;
class Driver{

    static main(args) {
        Scanner sc = new Scanner(System.in) ;
    EmployeeIntercept obj = new EmployeeIntercept() ;
    obj.Name = sc.nextLine() ;
    obj.ID = sc.nextLine() ;
    println obj.Display( obj.property['Name'] , obj.property['ID']) ;

    sc.close();
   
   //obj.metaClass.setAttribute(obj, 'property', 'ha')
    //println obj.metaClass.getProperties() ;

    }
}

class EmployeeIntercept implements GroovyInterceptable{

   public def property=[:]

    public def getProperty(String name)
    {
        return metaClass.getProperty(this , name)
    }

    def invokeMethod(String name , Object args)
    {
        return "called invokeMethod $name $args" ;
    }

    public void setProperty(String name , Object value){
       this.property[name] = value
      
    }


}

class Employee extends EmployeeIntercept{
    String name , id ;
}