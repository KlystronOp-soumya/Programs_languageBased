package com.demo.exceptions;

public class TryCatchDemo {
  
	    public static void main(String[] args) {  
	        try  
	        {  
	        int data=50/0; //may throw exception   
	        }  
	            //handling the exception  
	        catch(ArithmeticException e)  
	        {  
	            System.out.println(e);  
	            e.printStackTrace();
	        }  
	        System.out.println("After catch block");  
	    }  
	      
	 
}
