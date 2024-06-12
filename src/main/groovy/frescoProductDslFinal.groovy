class ProductDsl {
// write code
String up ;
String tid ;
String pdesc ;

 
   
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
   
   //write code
   void up(String userPassword){
    this.up = userPassword ;
   // println "My password is \"${userPassword}\""
   }

   void tid(String TransactionId)
   {
    this.tid = TransactionId ;
   // println "Transaction id for this product is \"${TransactionId}\""
   }

   void pdesc (String productdesc)
   {
    this.pdesc = productdesc ;
    println productdesc ;
   }

    void  show(){
    println "[ up: " + this.up + " tid: " + this.tid + " pdesc: " + this.pdesc + " ]" ; 
   }
}

class Solution{
 static void main(String[] args)
{
    Scanner sc = new Scanner(System.in) ;
    String userPassword = sc.nextLine();
    String TransactionId = sc.nextLine() ;
    String productdesc = sc.nextLine() ;
    
    
    sc.close();

    ProductDsl.display { 
    delegate.up userPassword
    delegate.tid TransactionId
    delegate.pdesc productdesc
   
}

    
}
 }   
