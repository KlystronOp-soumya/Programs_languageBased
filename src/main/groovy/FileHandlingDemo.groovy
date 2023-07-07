import java.io.File 
class Example { 
   static void main(String[] args) { 

      new File("../resources/lorem.txt").eachLine {  
         line -> println "line : $line"; 
      }

       new File("../resources/lorem.txt").withWriter('utf-8') { 
         writer -> writer.writeLine 'Hello World' 
      } 
   } 

    
}