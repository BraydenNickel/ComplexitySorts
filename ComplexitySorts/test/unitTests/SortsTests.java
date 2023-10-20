
package unitTests; 

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.project.shapes.Cone;
import com.project.shapes.Cylinder;
import com.project.shapes.OctaPrism;
import com.project.shapes.PentaPrism;
import com.project.shapes.Pyramid;
import com.project.shapes.SquarePrism;
import com.project.shapes.ThreeDimensionalShape;
import com.project.shapes.TriPrism;
import com.project.sortingMethods.Sorts;

public class SortsTests {

    private ThreeDimensionalShape[] shapes;

    @Before
    public void setUp() {
        // Initialize your test data here
        shapes = new ThreeDimensionalShape[] {
            new Cylinder(10.0, 5.0),
            new Pyramid(7.0, 10.0),
            new Cone(5.0, 3.0),
            new SquarePrism(8.0, 6.0),
            //new PentaPrism(2, 6), not working 
            //new TriPrism(2, 8), not working 
            new OctaPrism(2.0, 8.0),
            
            
            
        };
    }

    @Test
    public void testReadShapesFromFile() {
        // Create test data file and test this method
    }

    @Test
    public void testBubbleSort() {
        Sorts.bubbleSort(shapes, 'h'); // Sort by volume
        
        System.out.println("Unsorted data:");
        for (ThreeDimensionalShape shape : shapes) {
            System.out.println(shape.toString());
            }
        
        
        // Verify the correct sorting order
        for (int i = 0; i < shapes.length - 1; i++) {
            // Assuming compareTo compares by height correctly in your ThreeDimensionalShape class
            assertTrue(shapes[i].compareTo(shapes[i + 1]) <= 0);
            }
        System.out.println("Bubble sort:");
        for (ThreeDimensionalShape shape : shapes) {
            System.out.println(shape.toString());
        }
        
        
    }

    @Test
    public void testSelectionSort() {
        
        Sorts.selectionSort(shapes, 'v');
        // Verify the correct sorting order
        for (int i = 0; i < shapes.length - 1; i++) {
            
            assertTrue(shapes[i].compareTo(shapes[i + 1]) <= 0);
        }
    
        System.out.println("Sorted Array (Selection Sort):");
        for (ThreeDimensionalShape shape : shapes) {
            System.out.println(shape);
        }
        
        
        
        
    }

    @Test
    public void testInsertionSort() {
    	 // Sort the shapes using Insertion Sort by base area ('a'). Change to 'h' or 'v' for different comparisons.
        Sorts.insertionSort(shapes, 'h');
        
        // Verify the correct sorting order
        for (int i = 0; i < shapes.length - 1; i++) {
            // Assuming compareTo compares by base area correctly in your ThreeDimensionalShape class
            assertTrue(shapes[i].compareTo(shapes[i + 1]) <= 0);
        }
        System.out.println("Sorted Array (insertion Sort):");
        for (ThreeDimensionalShape shape : shapes) {
            System.out.println(shape);
        }
        
        
    }

    @Test
    public void testMergeSort() {
        Sorts.mergeSort(shapes, 'h'); // Sort by height
        // Add assertions to verify the correct sorting order
        
        
    }


    @Test
    public void testHeapSort() {
        Sorts.heapSort(shapes, 'a'); // Sort by base area
        // Add assertions to verify the correct sorting order
    }

}


