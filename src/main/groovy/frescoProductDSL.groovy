import java.util.Scanner ;
class ProductDsl {
// write code
String up ;
String tid ;
String pdesc ;


static void main(String[] args)
{
    Scanner sc = new Scanner(System.in) ;
    def userPassword = sc.nextLine() ;
    def TransactionId = sc.nextLine() ;
    def productdesc = sc.nextLine() ;

    sc.close();
/*
ProductDsl.display ({ 
  up(userPassword) // calling the methods with out object so static and we need to assign an object
  tid(TransactionId)
  pdesc(productdesc)
   
})
*/

// can not use any other keyword apart from delegate
// it will throow no property found exception
ProductDsl.display({
    it -> 
    {
        
       delegate.up(userPassword) ;
       delegate.tid(TransactionId) ;
       delegate.pdesc(productdesc) ;
       delegate.display() ;
    }

}) ;

}
 
   
   def static display(closure) { 
     // write code
     ProductDsl prodDsl = new ProductDsl() ;

    // Since the method is static hence no object is defined
    // we need to create the object and assign it to closure implicit object reference
     closure.delegate = prodDsl ;
     // upon calling the closure it calls the setter methods
     // we can also omit the brackets in method calls inside closure
     closure() //calling the closure to set the values

   }
   
   void up(String userPassword){
    this.up = userPassword ;
   }

   void tid(String TransactionId)
   {
    this.tid = TransactionId ;
   }

   void pdesc (String productdesc)
   {
    this.pdesc = productdesc ;
   }

   void display(){
    println "[ up: " + this.up + " tid: " + this.tid + " pdesc: " + this.pdesc + " ]" ; 
   }
}