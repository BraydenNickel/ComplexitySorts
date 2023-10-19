package com.project.shapes;

import java.util.Comparator;

public abstract class ThreeDimensionalShape implements Comparable<ThreeDimensionalShape>{
	double height;
	
	public ThreeDimensionalShape(double height) {
		this.height = height;
	}
	
	public abstract double calculateBaseArea();
	
	public abstract double calculateVolume();
	
	@Override
	public int compareTo(ThreeDimensionalShape other) {
		return Double.compare(this.height, other.height);
	}
	
	public double getHeight() {
		return height;
	}
	
	public static Comparator<ThreeDimensionalShape> shapeComparator(char choice){
		switch (choice) {
		case 'h':
			return Comparator.comparing(ThreeDimensionalShape::getHeight);
		case 'v':
			return Comparator.comparing(ThreeDimensionalShape::calculateVolume);
		case 'a': 
			return Comparator.comparing(ThreeDimensionalShape::calculateBaseArea);
			default:
				throw new IllegalArgumentException("Invalid comparison choice: " + choice);
		}
	}
}
