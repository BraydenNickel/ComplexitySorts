package com.project.shapes;

public abstract class Prism  extends ThreeDimensionalShape{
	double sideLength;
	
	public Prism(double height, double sideLength) {
		super(height);
		this.sideLength = sideLength;
	}

}
