/**
 * 
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.shapes.Cone;
import com.project.shapes.Cylinder;
import com.project.shapes.ThreeDimensionalShape;
import com.project.sortingMethods.*;

/**
 * @author Ruthless
 *
 */
public class ShapeTests {

	private ThreeDimensionalShape[] shapes;
	@Before
    public void setUp() {
        // Create an array of shapes for testing
        shapes = new ThreeDimensionalShape[] {
            new Cone(5.0, 8.0),
            new Cone(4.0, 7.0),
            new Cone(6.0, 6.0),
            // Add more shapes here for testing
        };
    }
	@After
	public void tearDown() {
		
		shapes = null;
	}
	
	@Override
	public String toString() {
		String height = null;
		String radius = null;
		return "Cone - Hieght: " + height + ", Radius: " + radius;
	}

	@Test
    public void testBubbleSort() {
        // Make a copy of the original array for comparison
        ThreeDimensionalShape[] original = Arrays.copyOf(shapes, shapes.length);

        // Sort the shapes using bubble sort
        Sorts.bubbleSort(shapes, 'h'); // Replace 'h' with the appropriate comparison type

        // Sort the original array using Java's built-in sorting for comparison
        Arrays.sort(original, ThreeDimensionalShape.shapeComparator('h'));

        // Check if the sorted array matches the expected result
        assertArrayEquals(original, shapes);
        
        System.out.println("Sorted Array (Bubble Sort):");
        for (ThreeDimensionalShape shape : shapes) {
            System.out.println(shape);
        }
        
    }
	
	@Test
    public void testCylinderToString() {
        Cylinder cylinder = new Cylinder(5.0, 2.0); // Replace with actual values
        String expected = "Cylinder with height: 5.0 and radius: 2.0";
        String actual = cylinder.toString();
        assertEquals(expected, actual);
        
    }
}
