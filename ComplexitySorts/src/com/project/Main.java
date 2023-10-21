package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.project.shapes.Cone;
import com.project.shapes.Cylinder;
import com.project.shapes.OctaPrism;
import com.project.shapes.PentaPrism;
import com.project.shapes.Pyramid;
import com.project.shapes.SquarePrism;
import com.project.shapes.ThreeDimensionalShape;
import com.project.shapes.TriPrism;
import com.project.sortingMethods.Sorts;

/**
 * @author Ruthless aka Brayden
 * @author Ethan
 * @author Kyle
 */

public class Main {

    public static void main(String[] args) {
        String fileName = null;
        char compareType = ' ';
        char sortAlgorithm = ' ';

        // Parse command line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-f")) {
                fileName = args[i + 1];
            } else if (args[i].equalsIgnoreCase("-t")) {
                compareType = args[i + 1].charAt(0);
            } else if (args[i].equalsIgnoreCase("-s")) {
                sortAlgorithm = args[i + 1].charAt(0);
            }
        }

        if (fileName == null || compareType == ' ' || sortAlgorithm == ' ') {
            System.out.println("Invalid command line arguments. Usage: java -jar sort.jar -f <file_name> -t <v|h|a> -s <b|s|i|m|q|z>");
            return;
        }

        // Read shapes from the file and store them in an array
        ThreeDimensionalShape[] shapes = readShapesFromFile(fileName);

        if (shapes == null || shapes.length == 0) {
            System.out.println("No valid shapes found in the file.");
            return;
        }

        // Sort the array using the selected sorting algorithm
        long startTime = System.currentTimeMillis();
        switch (sortAlgorithm) {
            case 'b':
                Sorts.bubbleSort(shapes, compareType);
                break;
            case 's':
                Sorts.selectionSort(shapes, compareType);
                break;
            case 'i':
                Sorts.insertionSort(shapes, compareType);
                break;
            case 'm':
                Sorts.mergeSort(shapes, compareType);
                break;
            case 'q':
                Sorts.quickSort(shapes, 0, shapes.length - 1, compareType);
                break;
            case 'z':
                Sorts.heapSort(shapes, compareType);
                break;
            default:
                System.out.println("Invalid sorting algorithm choice.");
                return;
        }
        long endTime = System.currentTimeMillis();

        // Print sorted shapes and timing information
        printSortedShapes(shapes, compareType, sortAlgorithm, startTime, endTime);
    }

    private static ThreeDimensionalShape[] readShapesFromFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            if (fileScanner.hasNextInt()) {
                int numShapes = fileScanner.nextInt();
                ThreeDimensionalShape[] shapes = new ThreeDimensionalShape[numShapes];

                for (int i = 0; i < numShapes; i++) {
                    if (fileScanner.hasNext()) {
                        String shapeType = fileScanner.next().toLowerCase();
                        double value1 = fileScanner.nextDouble();
                        double value2 = fileScanner.nextDouble();

                        switch (shapeType) {
                            case "cylinder":
                                shapes[i] = new Cylinder(value1, value2);
                                break;
                            case "cone":
                                shapes[i] = new Cone(value1, value2);
                                break;
                            case "pyramid":
                                shapes[i] = new Pyramid(value1, value2);
                                break;
                            case "squareprism":
                                shapes[i] = new SquarePrism(value1, value2);
                                break;
                            case "triangularprism":
                                shapes[i] = new TriPrism(value1, value2);
                                break;
                            case "pentagonalprism":
                                shapes[i] = new PentaPrism(value1, value2);
                                break;
                            case "octagonalprism":
                                shapes[i] = new OctaPrism(value1, value2);
                                break;
                            default:
                                // Handle invalid shape type or throw an exception
                                break;
                        }
                    }
                }

                fileScanner.close();
                return shapes;
            } else {
                fileScanner.close();
                throw new IllegalArgumentException("Invalid data format in the file.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found, check if the file exists and is spelled correctly.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the file.");
        }

        return null; // Return null if there was an issue reading the file
    }

    private static void printSortedShapes(ThreeDimensionalShape[] shapes, char sortAlgorithm, char compareType, long startTime, long endTime) {
        System.out.println("Sorting by: " + sortAlgorithm);
        System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");
        System.out.println("First sorted shape: " + shapes[0].toString());
        System.out.println("Last sorted shape: " + shapes[shapes.length - 1].toString());
        
        for (int i = 999; i < shapes.length; i += 1000) {
            ThreeDimensionalShape shape = shapes[i];
            System.out.println(shape.toString());

            if (compareType == 'v') {
                System.out.println("Calculated Volume: " + shape.calculateVolume());
            } else if (compareType == 'a') {
                System.out.println("Calculated Base Area: " + shape.calculateBaseArea());
            } else if (compareType == 'h') {
                System.out.println("Height: " + shape.getHeight());
            }
        }
    }

}
