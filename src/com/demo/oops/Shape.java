package com.demo.oops;

public class Shape implements ShapeIntf {

	private int radius;
	private int sides;
	Shape()
	{}
	
	Shape(int side)
	{
		this.radius = side ;
	}
	@Override
	public double calcArea(int edge) {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double calArea(int edge1, int edge2) {
		// TODO Auto-generated method stub
		return edge1*edge2;
	}
	public int getRadius()
	{
		return this.radius ;
	}

}
