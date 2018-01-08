package com.algorithm.chapter2.sort;

import java.io.PrintStream;

public class MergeSort {
    public static void sortRecursion(Comparable[] data) {
        sortMergeRecursion(data, 0, data.length - 1);
    }

    private static void sortMergeRecursion(Comparable[] data, int headIndex, int endIndex) {

        if (endIndex - headIndex <= 0) {
            return;
        }
        if (endIndex - headIndex == 1) {
            if (data[endIndex].compareTo(data[headIndex]) < 0) {
                Comparable temp = data[headIndex];
                data[headIndex] = data[endIndex];
                data[endIndex] = temp;
                return;
            }
        }
        int middleIndex = headIndex + (endIndex - headIndex) / 2;
        if (middleIndex > endIndex){
            middleIndex = endIndex;
        }
        if (middleIndex < headIndex){
            middleIndex = headIndex;
        }
        if (middleIndex - headIndex > 0) {
            sortMergeRecursion(data, headIndex, middleIndex);
        }
        if (endIndex - middleIndex > 1) {
            sortMergeRecursion(data, middleIndex + 1, endIndex);
        }

        Comparable[] firstBuffer = new Comparable[middleIndex - headIndex + 1];
        Comparable[] secondBuffer = new Comparable[endIndex - middleIndex];
        for (int i = headIndex; i <= middleIndex; i++) {
            firstBuffer[i - headIndex] = data[i];
        }
        for (int i = middleIndex + 1; i <= endIndex; i++) {
            secondBuffer[i - middleIndex - 1] = data[i];
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = headIndex;
        while (resultIndex <= endIndex) {
            if (firstIndex < firstBuffer.length && secondIndex < secondBuffer.length) {
                if (firstBuffer[firstIndex].compareTo(secondBuffer[secondIndex]) < 0) {
                    data[resultIndex] = firstBuffer[firstIndex];
                    firstIndex++;
                } else {
                    data[resultIndex] = secondBuffer[secondIndex];
                    secondIndex++;
                }
            } else if (firstIndex < firstBuffer.length) {
                data[resultIndex] = firstBuffer[firstIndex];
                firstIndex++;
            } else if (secondIndex < secondBuffer.length) {
                data[resultIndex] = secondBuffer[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }
        return;
    }
}
