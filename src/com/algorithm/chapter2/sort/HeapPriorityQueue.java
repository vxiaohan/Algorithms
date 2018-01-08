package com.algorithm.chapter2.sort;


/**
 * @author XiaoHan
 */
public class HeapPriorityQueue<Key extends Comparable<Key>> {
    private Key[] heap;
    private int number = 0;

    public HeapPriorityQueue(int maxNumber) {
        heap = (Key[]) new Comparable[maxNumber + 1];
    }

    public int size() {
        return number;
    }

    public void insert(Key data) {
        number++;
        heap[number] = data;
        swim(number);
    }

    public Key delMax() {
        Key maxValue = heap[1];
        exchange(1, number);
        heap[number] = null;
        number--;
        sink(1);
        return maxValue;
    }

    public Key[] getHeap() {
        return heap;
    }

    private void exchange(int index1, int index2) {
        Key temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void swim(int index) {
        while (index >= 1 && heap[index / 2].compareTo(heap[index]) < 0) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }

    private void sink(int index) {
        while (index * 2 <= number) {
            int leftIndex = index * 2;
            int rightIndex = leftIndex + 1;
            if (rightIndex < number) {
                if (heap[index].compareTo(heap[leftIndex]) < 0
                        || heap[index].compareTo(heap[rightIndex]) < 0) {
                    if (heap[leftIndex].compareTo(heap[rightIndex]) < 0) {
                        exchange(index, rightIndex);
                        index = rightIndex;
                    }
                } else {
                    break;
                }
            } else {
                if (heap[index].compareTo(heap[leftIndex]) < 0) {
                    exchange(index, leftIndex);
                    index *= 2;
                } else {
                    break;
                }
            }
        }
    }
}
