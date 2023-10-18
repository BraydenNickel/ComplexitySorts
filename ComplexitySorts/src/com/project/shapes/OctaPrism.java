package com.project.shapes;

public class OctaPrism extends Prism {
	
	public OctaPrism(double height, double sideLength) {
		super(height, sideLength);
	}
	@Override
	public double calculateBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
	}
	@Override
	public double calculateVolume() {
		return(sideLength * sideLength * height) / 4 ;
	}
}
