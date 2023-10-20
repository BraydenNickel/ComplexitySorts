package com.project.shapes;

public class Cylinder extends ThreeDimensionalShape {
	double radius;
	
	public Cylinder(double height, double radius) {
		super("Cylinder", height);
		this.radius = radius;
	}
	
	@Override
	public double calculateBaseArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double calculateVolume() {
		return Math.PI * (radius * radius) * height;
	}
	
}
