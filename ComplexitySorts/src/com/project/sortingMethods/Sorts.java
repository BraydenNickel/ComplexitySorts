package com.project.sortingMethods;

import java.util.List;

import com.project.shapes.ThreeDimensionalShape;

public class Sorts {
	
	// QUICKSORT //
	public static void quickSort(ThreeDimensionalShape[] arr, int low, int high) {
		int pivot;
		// Termination Condition //
		if (low < high) {
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}
	
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
	
	public static void swap(ThreeDimensionalShape[] arr, int i, int j) {
		ThreeDimensionalShape temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// BUBBLE SORT //
	public static void bubbleSort(ThreeDimensionalShape[] arr) {
		int size = arr.length; // get size of array
		int pass, i;
		boolean swapped = true; // sets swap check to true
		
		for(pass = size - 1; pass >= 0 && swapped; pass--) {
			swapped = false; // sets swapped check to false for each pass
			for(i = 0; i < pass; i++) {
				if(compareShapes(arr[i], arr[i + 1]) > 0) {
					ThreeDimensionalShape temp = arr[i]; // swaps array if array is out of order
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	// SELECTION SORT //
	
	public static void selectionSort(ThreeDimensionalShape[] arr) {
	    int size = arr.length; // get size of array
	    int i, j, min;
	    ThreeDimensionalShape temp;
	    for (i = 0; i < size - 1; i++) {
	        min = i; // assume index has a min value
	        for (j = i + 1; j < size; j++) {
	            if (compareShapes(arr[j], arr[min]) < 0) {
	                min = j; // update index for min value
	            }
	        }
	        temp = arr[min]; // get value at index min
	        arr[min] = arr[i]; // set value at index min to value at index i
	        arr[i] = temp; // set value at index i to temp
	    }
	}
	
	// INSERTION SORT //
	
	public static void insertionSort(ThreeDimensionalShape[] arr) {
	    int size = arr.length; // get size of array
	    int i, j;
	    ThreeDimensionalShape temp;
	    for (i = 1; i < size; i++) {
	        temp = arr[i]; // store the current shape in temp
	        j = i; // initialize j to the current index
	        // move shapes greater than temp to the right
	        while (j > 0 && compareShapes(arr[j - 1], temp) > 0) {
	            arr[j] = arr[j - 1]; // shift elements to the right
	            j--; // move j to the previous index
	        }
	        arr[j] = temp; // place temp in the correct position
	    }
	}


}
