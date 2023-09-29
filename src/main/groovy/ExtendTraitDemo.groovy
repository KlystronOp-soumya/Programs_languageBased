trait Name{
    String name 
}

trait SurName extends Name
{
    String title
    String showFullName() {print "Full Name:${title} ${name} "}
}

class Person implements Name , SurName
{
    def s1
    def s2
}

def obj =new  Person()

obj.setS1("Paul")
obj.setS2("Soumya")
obj.title = obj.getS1()
obj.name = obj.getS2()
obj.showFullName()

def obj2 = new Person(title: "Paul" , name:"SP")
obj2.showFullName()