package com.project.shapes;

public class Pyramid extends ThreeDimensionalShape{
	double sideLength;
	
	public Pyramid(double height, double sideLength) {
		super("Pyramid", height);
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

}
