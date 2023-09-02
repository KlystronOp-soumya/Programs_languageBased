@interface Simple { 
   String str1() default "HelloWorld"; 
}

enum DayOfWeek { mon, tue, wed, thu, fri, sat, sun } 
@interface Scheduled {
   DayOfWeek dayOfWeek() //returns the enum type
} 

@interface Simple {} 
@Simple 
class User {
   String username
   int age
}
 
def user = new User(username: "Joe",age:1); 
println(user.age); 
println(user.username);