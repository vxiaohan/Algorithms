package com.algorightm.chapter2.sort;

/**
 * @author Xiao Han
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            // Find min index
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
