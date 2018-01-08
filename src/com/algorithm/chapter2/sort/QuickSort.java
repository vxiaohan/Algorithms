package com.algorithm.chapter2.sort;

/**
 * @author XiaoHan
 */
public class QuickSort {
    public static void sortRecursion(Comparable[] data) {
        sortRecursion(data, 0, data.length - 1);
    }

    public static void sortRecursion(Comparable[] data, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        int middleIndex = partition(data, startIndex, endIndex);
        sortRecursion(data, startIndex, middleIndex - 1);
        sortRecursion(data, middleIndex + 1, endIndex);

    }

    private static void exchange(Comparable[] data, int index1, int index2) {
        Comparable temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static int partition(Comparable[] data, int startIndex, int endIndex) {
        Comparable standard = data[startIndex];
        int beforeIndex = startIndex + 1;
        int afterIndex = endIndex;
        while (beforeIndex < afterIndex) {
            while (standard.compareTo(data[beforeIndex]) > 0) {
                if (beforeIndex == endIndex) {
                    break;
                }
                beforeIndex++;
            }
            while (standard.compareTo(data[afterIndex]) < 0) {
                if (afterIndex == startIndex) {
                    break;
                }
                afterIndex--;
            }
            if (beforeIndex >= afterIndex) {
                break;
            } else {
                exchange(data, beforeIndex, afterIndex);
            }
        }
        exchange(data, startIndex, afterIndex);
        return afterIndex;
    }
}
