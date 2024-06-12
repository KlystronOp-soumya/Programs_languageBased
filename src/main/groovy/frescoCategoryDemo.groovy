class Speak {
    static def  Uppercase(String self){
         self.toUpperCase()+"!" ;
    }
    static def Sentence(String self , boolean b)
    {
        return b?"yes.. "+self : "no.. "+self
    }
    static def Groovy(String self){
        return self+". Ofcourse Yes!"
    }
}
BufferedReader rd = new BufferedReader(new InputStreamReader(System.in)) ;
String str1 = rd.readLine() ;
String str2 = rd.readLine() ;
String str3 = rd.readLine() ;
String str4 = rd.readLine() ;
use (Speak) {
    println str1.Uppercase() ;
    println str2.Sentence(true) ;
    println str3.Sentence(false) ;
    println str4.Groovy() ;
}
 
rd.close()