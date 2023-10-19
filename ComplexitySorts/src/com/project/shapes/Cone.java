package com.project.shapes;

public class Cone extends ThreeDimensionalShape{
	double radius;

	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double calculateBaseArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double calculateVolume() {
		return (Math.PI * radius * radius * height) / 3;
	}

}
