package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sorting {

    //O(n^2)
    public void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
    }

    //O(n^2)
    public void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {

            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //O(n^2) - worst case
    public void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean swapped = false;

            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }

    /**
     * Left = start index
     * right = end index
     */
    public void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    //Considering one pivot and placing smaller elements to the left and greater elements to the right of pivot
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];         //Considering right as Pivot point

        int p = left;
        for(int i = left; i < right; i++) {     // i < right because right already consider a pivot
            if(arr[i] < pivot) {
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
                p++;
            }
        }

        int temp = arr[p];
        arr[p] = pivot;
        arr[right] = temp;
        return p;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if(left < right) {

            int mid =  left + (right - left) / 2;       //Example : 20 - 10 = 10 ->  (10) / 2 = 5 -> 10 + 5 = 15

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;            // +1 because of zero index start
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2) {
            if(leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while(i < n1) {
            arr[k++] = leftArr[i++];
        }

        while(j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        Sorting sort = new Sorting();
        int[] arr = new int[]{4, 7, 2, 8, 3, 5, 22, 6, 7, 7, 1};

        //Selection Sort
        //sort.selectionSort(arr);

        //Insertion sort
        //sort.insertionSort(arr);

        //Bubble Sort
        //sort.bubbleSort(arr);

        //Quick Sort
        //sort.quickSort(arr, 0, arr.length - 1);

        //Merge Sort
        sort.mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}
