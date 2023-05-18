package edu.sdsu.cs160l.algorithm.sort;

import java.util.Comparator;

/**
 * TODO assignment (4 points)
 *  implement mergesort in a similar way as quick sort and bubble sort structurally
 *
 *  hint to create a generic array use T[] t = (T[])(new Object[])
 */
public class MergeSort implements Sorter {
    @Override
    @SuppressWarnings("unchecked")
    public <T> void sort(T[] c) {
        Comparable[] comparable = (Comparable[]) c;
        sort(comparable, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] c, Comparator<? super T> comparisonStrategy) {
        T[] tempArray = (T[])(new Object[c.length]); // create temporary array for merging
        mergeSort(c, tempArray, 0, c.length - 1, comparisonStrategy);
    }

    private <T> void mergeSort(T[] arr, T[] tempArray, int leftStart, int rightEnd, Comparator<T> comparisonStrategy) {
        if (leftStart >= rightEnd) { // base case: single element or empty array
            return;
        }
        int mid = (leftStart + rightEnd) / 2; // find the middle index
        mergeSort(arr, tempArray, leftStart, mid, comparisonStrategy); // sort the left half recursively
        mergeSort(arr, tempArray, mid + 1, rightEnd, comparisonStrategy); // sort the right half recursively
        merge(arr, tempArray, leftStart, rightEnd, comparisonStrategy); // merge the two halves
    }

    private <T> void merge(T[] arr, T[] tempArray, int leftStart, int rightEnd, Comparator<T> comparisonStrategy) {
        int leftEnd = (leftStart + rightEnd) / 2; // find the end of the left half
        int rightStart = leftEnd + 1; // find the start of the right half
        int size = rightEnd - leftStart + 1; // calculate the size of the merged sub-array

        int leftIndex = leftStart; // initialize left index
        int rightIndex = rightStart; // initialize right index
        int tempIndex = 0; // initialize temporary index

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) { // while both halves have elements
            if (comparisonStrategy.compare(arr[leftIndex], arr[rightIndex]) <= 0) { // if left element is smaller or equal
                tempArray[tempIndex] = arr[leftIndex]; // copy left element to temporary array
                leftIndex++; // move left index
            } else { // if right element is smaller
                tempArray[tempIndex] = arr[rightIndex]; // copy right element to temporary array
                rightIndex++; // move right index
            }
            tempIndex++; // move temporary index
        }

        // copy any remaining elements from left half to temporary array
        while (leftIndex <= leftEnd) {
            tempArray[tempIndex] = arr[leftIndex];
            leftIndex++;
            tempIndex++;
        }

        // copy any remaining elements from right half to temporary array
        while (rightIndex <= rightEnd) {
            tempArray[tempIndex] = arr[rightIndex];
            rightIndex++;
            tempIndex++;
        }

        // copy sorted elements from temporary array back to original array
        for (int i = 0; i < size; i++) {
            arr[leftStart + i] = tempArray[i];
        }
    }
}
