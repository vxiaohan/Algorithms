package com.algorightm.chapter2.sort;

public class ShellSort {
    private static void exchange(Comparable[] data, int index_1, int index_2) {
        Comparable temp = data[index_1];
        data[index_1] = data[index_2];
        data[index_2] = temp;
    }

    public static void sort(Comparable[] data) {
        int length = data.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && data[j].compareTo(data[j - 1]) < 0; j -= h) {
                    exchange(data, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
