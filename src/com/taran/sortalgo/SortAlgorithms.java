package com.taran.sortalgo;

import java.util.Random;

public class SortAlgorithms {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] getRandomArray(int length, int max, int min) {
        int[] arr = new int[length];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max-min+1) + min;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        if(i==j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int unsortedLastIndex = arr.length-1;
        while(unsortedLastIndex > 0) {
            int index = 0;
            while (index < unsortedLastIndex) {
                if (arr[index] > arr[index + 1]) {
                    swap(arr, index, index + 1);
                }
                index++;
            }
            unsortedLastIndex--;
        }
       /* for(int i = arr.length-1 ; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            printArray(arr);
        }*/
    }

    public static void selectionSort(int[] arr) {
        int unsortedLastIndex = arr.length-1;
        while(unsortedLastIndex > 0) {
            int largestIndex = 0;
            for (int j = 1; j <= unsortedLastIndex; j++) {
                if(arr[j] > arr[largestIndex]) {
                    largestIndex = j;
                }
            }
            swap(arr, largestIndex, unsortedLastIndex);
            unsortedLastIndex--;
            printArray(arr);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++) {
            int sortedIndex = unsortedIndex-1;
            int toInsert = arr[unsortedIndex];
            while(sortedIndex >= 0 && toInsert < arr[sortedIndex]) {
                arr[sortedIndex+1] = arr[sortedIndex];
                sortedIndex--;
            }
            //printArray(arr);
            arr[sortedIndex+1] = toInsert;
            //printArray(arr);
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if(endIndex - startIndex < 2) {
            return;
        }
        int splitIndex = (startIndex + endIndex)/2;

        mergeSort(arr, startIndex, splitIndex);
        mergeSort(arr, splitIndex, endIndex);

        merge(arr, startIndex, splitIndex, endIndex);
    }

    public static void merge(int[] arr, int startIndex, int splitIndex, int endIndex) {
        if(arr[splitIndex-1] < arr[splitIndex]) {
            return;
        }
        int[] mergedArray = new int[endIndex - startIndex];
        int i = startIndex, j = splitIndex, temp = 0;

        while (i < splitIndex && j < endIndex) {
            mergedArray[temp++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        System.arraycopy(arr, i, arr, startIndex+temp, splitIndex-i);
        System.arraycopy(mergedArray, 0, arr, startIndex, temp);
     }
}
