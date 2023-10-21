package com.project.shapes;

public abstract class Prism  extends ThreeDimensionalShape{
	double sideLength;
	
<<<<<<< Updated upstream
	public Prism(double height, double sideLength) {
		super(height);
		this.sideLength = sideLength;
=======
	public Prism(String shapeType, double height, double sideLength) {
		super(shapeType, height);  
		this.sideLength = sideLength; 
>>>>>>> Stashed changes
	}

}
