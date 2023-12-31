package com.project.shapes;

public class PentaPrism extends Prism {
    public PentaPrism(double height, double sideLength) {
		super("Pentagonal Prism", height, sideLength);
	}

    @Override
    public double calculateBaseArea() {
        return (5 * sideLength * sideLength * Math.tan(Math.toRadians(54))) / 4;
    }

    @Override
    public double calculateVolume() {
        return (sideLength * sideLength * height);
    }
    
}
