package com.project.sortingMethods;

import java.util.Arrays;
import java.util.Comparator;

import com.project.shapes.ThreeDimensionalShape;

public class ShapeSorter {
    public static void sortShapes(ThreeDimensionalShape[] shapes, char compareType, char sortingAlgorithm) {
        Comparator<ThreeDimensionalShape> customComparator = ThreeDimensionalShape.shapeComparator(compareType);

        if (customComparator == null) {
            System.out.println("Invalid compareType: " + compareType);
            return;
        }

        if (shapes != null) {
            Arrays.sort(shapes, customComparator);
        }
    }
}