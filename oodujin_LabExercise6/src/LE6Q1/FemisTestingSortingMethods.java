package LE6Q1;

import java.util.*;

public class FemisTestingSortingMethods {

    // Display header information about the lab exercise
    public static void myHeader(int labNumber, int questionNumber) {
        // Hardcoded details to identify the student and lab information
        final String YourFirstName, YourLastName, GoalOfExercise;
        final int YourStudentNumber = 251368776;
        String SeparationBars = "=======================================================";

        // Purpose: These details help the grader identify the student and understand the lab's goals
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Write all the sorting methods (discussed in the class) in their generic form (except for Bucket-sort) and check their execution time for an Integer type dataset";

        // Display formatted header
        System.out.printf("%s\nLab Exercise %d, Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, labNumber, questionNumber, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    // Display footer indicating the end of the exercise
    public static void myFooter(int labE_number, int q_number) {
        final String YourFirstName = "Femi";
        String SeparationBars = "=======================================================";

        // Display formatted footer
        System.out.printf("%s\nCompletion of Lab Exercise %d, Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, labE_number, q_number, YourFirstName, SeparationBars);
    }

    // Generic Selection Sort
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long startTime = System.nanoTime(); // Start timing
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            T temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return System.nanoTime() - startTime; // Return elapsed time
    }

    // Generic Bubble Sort
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long startTime = System.nanoTime(); // Start timing
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                // Compare adjacent elements and swap if necessary
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return System.nanoTime() - startTime; // Return elapsed time
    }

    // Generic Insertion Sort
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long startTime = System.nanoTime(); // Start timing
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;
            // Move elements that are greater than the key to one position ahead
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return System.nanoTime() - startTime; // Return elapsed time
    }

    // Generic Merge Sort
    public static <T extends Comparable<? super T>> long mergeSort(T[] a) {
        long startTime = System.nanoTime(); // Start timing
        mergeSortHelper(a, 0, a.length - 1);
        return System.nanoTime() - startTime; // Return elapsed time
    }

    // Helper function for recursive Merge Sort
    private static <T extends Comparable<? super T>> void mergeSortHelper(T[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(a, left, mid);
            mergeSortHelper(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    // Merging two halves in Merge Sort
    private static <T extends Comparable<? super T>> void merge(T[] a, int left, int mid, int right) {
        T[] temp = Arrays.copyOfRange(a, left, right + 1); // Create a temporary array
        int i = 0, j = mid - left + 1, k = left;

        // Merge the two halves into the array
        while (i <= mid - left && j < temp.length) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                a[k++] = temp[i++];
            } else {
                a[k++] = temp[j++];
            }
        }
        // Copy remaining elements
        while (i <= mid - left) {
            a[k++] = temp[i++];
        }
    }

    // Generic Quick Sort
    public static <T extends Comparable<? super T>> long quickSort(T[] a, int low, int high) {
        long startTime = System.nanoTime(); // Start timing
        quickSortHelper(a, low, high);
        return System.nanoTime() - startTime; // Return elapsed time
    }

    // Helper function for recursive Quick Sort
    private static <T extends Comparable<? super T>> void quickSortHelper(T[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSortHelper(a, low, pivotIndex - 1);
            quickSortHelper(a, pivotIndex + 1, high);
        }
    }

    // Partition function for Quick Sort
    private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high) {
        T pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;
                T temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        T temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }

    // Bucket Sort for Integer Arrays
    public static long bucketSort(Integer[] a) {
        long startTime = System.nanoTime(); // Start timing
        int max = Arrays.stream(a).max(Integer::compare).orElse(0);
        int min = Arrays.stream(a).min(Integer::compare).orElse(0);
        int bucketCount = (max - min) / a.length + 1;

        List<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : a) {
            int bucketIndex = (num - min) / a.length;
            buckets[bucketIndex].add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // Sort individual buckets
            for (int num : bucket) {
                a[index++] = num;
            }
        }

        return System.nanoTime() - startTime; // Return elapsed time
    }

    public static void main(String[] args) {
        //Calling Header Method
        myHeader(6,1);

        int sz = 50000; // Change to 5 OR 50,000 for smaller OR larger dataset test
        Integer[] array = new Integer[sz];
        Integer[] backup = new Integer[sz];

        System.out.printf("Testing execution time of different sorting methods for sorting %d random numbers:\n", sz);

        // Populate array with random integers between 13 and 93
        for (int i = 0; i < sz; i++) {
            array[i] = 13 + (int) (Math.random() * 81);
        }
        System.arraycopy(array, 0, backup, 0, sz);

//        System.out.println("The unsorted list: " + Arrays.toString(array));

        // Collections.sort
        System.arraycopy(backup, 0, array, 0, sz);
        long collectionsTime = System.nanoTime();
        Arrays.sort(array);
        collectionsTime = System.nanoTime() - collectionsTime;
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", (collectionsTime / 1e6));
//        System.out.printf("The sorted list using Collections' sort method: %s\n", Arrays.toString(array));

        // Selection Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long selectionTime = selectionSort(array);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n", (selectionTime / 1e6));
//        System.out.println("The sorted list using selection-sort: " + Arrays.toString(array));

        //Bubble Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long bubbleTime = bubbleSort(array);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n", (bubbleTime / 1e6));
//        System.out.println("The sorted list with Bubble-sort: " + Arrays.toString(array));

        //Insertion Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long insertionTime = insertionSort(array);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n", (insertionTime / 1e6));
//        System.out.println("The sorted list with Insertion-sort: " + Arrays.toString(array));

        //Merge Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long mergeTime = mergeSort(array);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n", (mergeTime / 1e6));
//        System.out.println("The sorted list with Merge-sort: " + Arrays.toString(array));

        //Quick Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long quickTime = quickSort(array, 0, array.length - 1);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n", (quickTime / 1e6));
//        System.out.println("The sorted list with Quick sort: " + Arrays.toString(array));

        //Bucket Sort
        System.arraycopy(backup, 0, array, 0, sz);
        long bucketTime = bucketSort(array);
//        System.out.printf("\nThe unsorted list: %s\n", Arrays.toString(backup));
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds\n", (bucketTime / 1e6));
//        System.out.println("The sorted list with Bucket-sort: " + Arrays.toString(array));

        //Calling Footer Method
        myFooter(6,1);
    }
}
