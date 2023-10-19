package com.project.shapes;

public class SquarePrism extends Prism {
	public SquarePrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	@Override
	public double calculateBaseArea() {
		return sideLength * sideLength;
	}
	
	@Override
	public double calculateVolume() {
		return sideLength * sideLength * height;
	}

}
