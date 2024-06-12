import java.util.Scanner ;
class Sloution{
    //working demo
    static main(args) {
        Scanner sc = new Scanner(System.in) ;

        def obj = new SomeGroovyClass() ;
        obj.Name = sc.nextLine() ;
        obj.ID = sc.nextInt() ;
        obj.Experience = sc.nextFloat() ;
        obj.display(obj.name , obj.ID , obj.Experience)
        sc.close(); 
    }
}

class SomeGroovyClass {
    String Name ;
    int ID ;
    float Experience ;

    def invokeMethod(String name, Object args) {
        println "called invokeMethod $name $args"
        return "called invokeMethod $name $args"
    }

    def test() {
        return 'method exists'
    }
}

/*def someGroovyClass = new SomeGroovyClass()

assert someGroovyClass.test() == 'method exists'
assert someGroovyClass.someMethod() == 'called invokeMethod someMethod []'
someGroovyClass.display(1,2,3)*/