class Person {
    String name
    String toString() { name }          
}
def John = new Person(name:'John')        
def Ram = new Person(name:'Ram')      
def p = John                             
def gs = "Name: ${p}"    // closure is created .toString()         
assert gs == 'Name: John'                
p = Ram                               
assert gs == 'Name: John'                
John.name = 'Ram'                       
assert gs == 'Name: Ram'

/*
//create the Person class\
class Person
{
    String name
    
    String toString() {name}
}
class Solution{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String str = br.readLine()
        //write the closure
        def personObj = new Person(name:str)
        def gsClos = "Name is ${personObj}"
        print gsClos
    }
    
    
}
*/