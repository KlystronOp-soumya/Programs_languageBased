package com.demo.exceptions;

import java.io.*;  
class Foo{  
 void method()throws IOException{  
  throw new IOException("device error");  
 }  
}  
public class ThrowsDemo{  
   public static void main(String args[]){  
    try{  
     Foo f=new Foo();  
     f.method();  
    }catch(Exception e){System.out.println("exception handled"+e);}     
  
    System.out.println("after catch block");  
  }  
}  
