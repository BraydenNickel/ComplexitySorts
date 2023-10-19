
package com.project.sortingMethods;
import  com.project.shapes.ThreeDimensionalShape;



public class MergeSort {
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