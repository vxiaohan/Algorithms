package com.algorithm.chapter2.sort;

/**
 * @author Xiao Han
 */
public class InsertSort {
    private static void move(Comparable[] a, int sourceIndex, int desIndex) {
        Comparable temp = a[sourceIndex];
        for (int k = sourceIndex; k > desIndex; k--) {
            a[k] = a[k - 1];
        }
        a[desIndex] = temp;
    }

    static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertPosition = i;
            if (a[i].compareTo(a[0]) <= 0) {
                insertPosition = 0;
            } else {
                for (int j = i - 1; j > 0; j--) {
                    if (a[i].compareTo(a[j]) <= 0 && a[i].compareTo(a[j - 1]) >= 0) {
                        insertPosition = j;
                        break;
                    }
                }
            }
            if (insertPosition != i) {
                InsertSort.move(a, i, insertPosition);
            }
        }
    }
}
