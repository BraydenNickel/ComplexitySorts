package com.project.shapes;

public abstract class Prism  extends ThreeDimensionalShape{
	double sideLength;
	
	public Prism(String shapeType, double height, double sideLength) {
		super(shapeType, height);
		this.sideLength = sideLength; 
	}

}
