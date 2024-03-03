package com.demo.oops;

public class Circle extends Shape {
	
	private int diameter;
	Circle(){}
	
	Circle(int diameter)
	{
		super(diameter/2);
	}
	
	public void showArea()
	{
		System.out.println("Area of the circle is: "+ super.calcArea(super.getRadius()));
	}
	
	
}
