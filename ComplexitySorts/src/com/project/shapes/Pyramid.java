package com.project.shapes;

public class Pyramid extends ThreeDimensionalShape{
	double sideLength;
	
	public Pyramid(double height, double sideLength) {
		super(height);
		this.sideLength = sideLength;
	}
	
	@Override
	public double calculateBaseArea() {
		return sideLength * sideLength;
		
	}
	
	@Override 
	public double calculateVolume() {
		return(sideLength* sideLength * height) / 3;
	}
	
	@Override
	public String toString() {
	    return "Pyramid with height: " + height + " and side length: " + sideLength;
	}

}
