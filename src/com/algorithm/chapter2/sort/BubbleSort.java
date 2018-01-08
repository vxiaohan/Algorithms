package com.algorithm.chapter2.sort;

public class BubbleSort {
    public static void sort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            Comparable temp = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp.compareTo(data[j]) < 0) {
                    data[j + 1] = data[j];
                    data[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
