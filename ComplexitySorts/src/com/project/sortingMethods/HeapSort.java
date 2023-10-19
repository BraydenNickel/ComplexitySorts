package com.project.sortingMethods;

import java.util.Comparator;
import com.project.shapes.ThreeDimensionalShape;


public class HeapSort {
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
}
