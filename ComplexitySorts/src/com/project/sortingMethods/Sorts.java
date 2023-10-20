package com.project.sortingMethods;

import java.util.Comparator;
import com.project.shapes.ThreeDimensionalShape;

public class Sorts {
	
	// QUICKSORT //
	public static void quickSort(ThreeDimensionalShape[] arr, int low, int high, Comparator<ThreeDimensionalShape> comparator) {
	    int pivot;
	    if (low < high) {
	        pivot = partition(arr, low, high, comparator);
	        quickSort(arr, low, pivot - 1, comparator);
	        quickSort(arr, pivot + 1, high, comparator);
	    }
	}
	public static int partition(ThreeDimensionalShape[] arr, int low, int high, Comparator<ThreeDimensionalShape> comparator) {
	    ThreeDimensionalShape pivotShape = arr[low];
	    int left = low + 1;
	    int right = high;

	    while (true) {
	        while (left <= right && comparator.compare(arr[left], pivotShape) <= 0) {
	            left++;
	        }

	        while (left <= right && comparator.compare(arr[right], pivotShape) > 0) {
	            right--;
	        }

	        if (left > right) {
	            break;
	        }

	        swap(arr, left, right);
	        left++;
	        right--;
	    }

	    swap(arr, low, right);
	    return right;
	}
	
	/*
	public static void quickSort(ThreeDimensionalShape[] arr, int low, int high) {
		int pivot;
		// Termination Condition //
		if (low < high) {
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}
	*/
	/*
	public static int partition(ThreeDimensionalShape[] arr, int low, int high) {
		ThreeDimensionalShape pivotShape = arr[low];
		int left = low + 1;
		int right = high;
		
		while(true) // Moves left while array is <= pivot
			{
			while(left <= right && arr[left].compareTo(pivotShape) <= 0) 
				left++;
			// Moves right while array is > pivot
			while(left <= right && arr[right].compareTo(pivotShape) > 0) 
				right--;
			// If left and right intersect break loop
			if(left > right) 
				break;
			// swap number at left and right pointers
			swap(arr, left, right);
			left++;
			right--;
		}
		// swap pivot at low array with right array and return right array
		swap(arr, low, right);
		return right;
	}
	
	*/
	
	public static void swap(ThreeDimensionalShape[] arr, int i, int j) {
		ThreeDimensionalShape temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// BUBBLE SORT //
	public static void bubbleSort(ThreeDimensionalShape[] arr, char choice) {
		int size = arr.length; // get size of array
		int pass, i;
		boolean swapped = true; // sets swap check to true
		Comparator<ThreeDimensionalShape> comparator = ThreeDimensionalShape.shapeComparator(choice);
		
		for(pass = size - 1; pass >= 0 && swapped; pass--) {
			swapped = false; // sets swapped check to false for each pass
			for(i = 0; i < pass; i++) {
				if(comparator.compare(arr[i], arr[i + 1]) > 0) {
					ThreeDimensionalShape temp = arr[i]; // swaps array if array is out of order
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	// SELECTION SORT //
	
	public static void selectionSort(ThreeDimensionalShape[] arr, char choice) {
	    int size = arr.length; // get size of array
	    int i, j, min;
	    ThreeDimensionalShape temp;
		Comparator<ThreeDimensionalShape> comparator = ThreeDimensionalShape.shapeComparator(choice);

	    for (i = 0; i < size - 1; i++) {
	        min = i; // assume index has a min value
	        for (j = i + 1; j < size; j++) {
	            if (comparator.compare(arr[j], arr[min]) < 0) {
	                min = j; // update index for min value
	            }
	        }
	        temp = arr[min]; // get value at index min
	        arr[min] = arr[i]; // set value at index min to value at index i
	        arr[i] = temp; // set value at index i to temp
	    }
	}
	
	// INSERTION SORT //
	
	public static void insertionSort(ThreeDimensionalShape[] arr, char choice) {
	    int size = arr.length; // get size of array
	    int i, j;
	    ThreeDimensionalShape temp;
		Comparator<ThreeDimensionalShape> comparator = ThreeDimensionalShape.shapeComparator(choice);

	    for (i = 1; i < size; i++) {
	        temp = arr[i]; // store the current shape in temp
	        j = i; // initialize j to the current index
	        // move shapes greater than temp to the right
	        while (j > 0 && comparator.compare(arr[j - 1], temp) > 0) {
	            arr[j] = arr[j - 1]; // shift elements to the right
	            j--; // move j to the previous index
	        }
	        arr[j] = temp; // place temp in the correct position
	    }
	}

	// HEAP SORT//
	
	public static void heapSort(ThreeDimensionalShape[] arr, char choice) {
        Comparator<ThreeDimensionalShape> comparator = ThreeDimensionalShape.shapeComparator(choice);
        
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the current root with the last element
            ThreeDimensionalShape temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }

    private static void heapify(ThreeDimensionalShape[] arr, int n, int i, Comparator<ThreeDimensionalShape> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(arr[left], arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(arr[right], arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            ThreeDimensionalShape swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, comparator);
        }
    }

    
    public static void mergeSort(ThreeDimensionalShape[] shapes, char choice) {
        if (shapes == null || shapes.length <= 1) {
            return; // No need to sort
        }

        mergeSort(shapes, 0, shapes.length - 1, choice);
    }

    private static void mergeSort(ThreeDimensionalShape[] shapes, int left, int right, char choice) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively divide and sort the left and right halves
            mergeSort(shapes, left, middle, choice);
            mergeSort(shapes, middle + 1, right, choice);

            // Merge the two sorted halves
            merge(shapes, left, middle, right, choice);
        }
    }
    
    // MERGE SORT //

    private static void merge(ThreeDimensionalShape[] shapes, int left, int middle, int right, char choice) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        ThreeDimensionalShape[] leftArray = new ThreeDimensionalShape[n1];
        ThreeDimensionalShape[] rightArray = new ThreeDimensionalShape[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = shapes[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = shapes[middle + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (ThreeDimensionalShape.shapeComparator(choice).compare(leftArray[i], rightArray[j]) >= 0) {
                shapes[k] = leftArray[i];
                i++;
            } else {
                shapes[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            shapes[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            shapes[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
