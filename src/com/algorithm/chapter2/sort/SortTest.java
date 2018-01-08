package com.algorithm.chapter2.sort;

/**
 * @author Xiao Han
 */
public class SortTest {
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
    }

    public static boolean isEqual(Comparable[] a, Comparable[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    @org.junit.Test
    public void selectionSort() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        SelectionSort.sort(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        SelectionSort.sort(b);
        assert isSorted(b);
        Integer[] c = {1};
        SelectionSort.sort(c);
        assert isSorted(c);
    }

    @org.junit.Test
    public void insertSort() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        InsertSort.sort(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        InsertSort.sort(b);
        assert isSorted(b);
        Integer[] c = {1};
        InsertSort.sort(c);
        assert isSorted(c);
    }

    @org.junit.Test
    public void bubbleSort() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        BubbleSort.sort(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        BubbleSort.sort(b);
        assert isSorted(b);
        Integer[] c = {1};
        BubbleSort.sort(c);
        assert isSorted(c);
    }

    @org.junit.Test
    public void shellSort() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        ShellSort.sort(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        ShellSort.sort(b);
        assert isSorted(b);
        Integer[] c = {1};
        ShellSort.sort(c);
        assert isSorted(c);
        Character[] test_char = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        ShellSort.sort(test_char);
        assert isSorted(test_char);
    }

    @org.junit.Test
    public void mergeSortRecursion() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        MergeSort.sortRecursion(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        MergeSort.sortRecursion(b);
        assert isSorted(b);
        Integer[] c = {1};
        MergeSort.sortRecursion(c);
        assert isSorted(c);
        Character[] test_char = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        MergeSort.sortRecursion(test_char);
        assert isSorted(test_char);
    }

    @org.junit.Test
    public void mergeSortNonRecursion() {
        Integer[] a = {2, 3, 1, 5, 6, 3};
        MergeSort.sortNonRecursion(a);
        Integer[] result = {1, 2, 3, 3, 5, 6};
        assert isEqual(a, result);
        assert isSorted(a);
        Integer[] b = {};
        MergeSort.sortNonRecursion(b);
        assert isSorted(b);
        Integer[] c = {1};
        MergeSort.sortNonRecursion(c);
        assert isSorted(c);
        Character[] test_char = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        MergeSort.sortNonRecursion(test_char);
        assert isSorted(test_char);
    }
}