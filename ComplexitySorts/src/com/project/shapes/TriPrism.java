package com.project.shapes;

public class TriPrism extends Prism{
	public TriPrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	@Override
	public double calculateBaseArea() {
		return (sideLength * sideLength * Math.sqrt(3)) / 4;
	}
	
	@Override
	public double calculateVolume() {
		return (sideLength * sideLength * height) / 2;
	}

}
