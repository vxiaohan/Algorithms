package com.algorithm.chapter2.sort;


/**
 * @author XiaoHan
 */
public class HeapPriorityQueue<Key extends Comparable<Key>> {
    private Key[] heap;
    private int number = 0;

    public HeapPriorityQueue() {
        heap = (Key[]) new Comparable[11];
    }

    public HeapPriorityQueue(int maxNumber) {
        heap = (Key[]) new Comparable[maxNumber + 1];
    }

    public int size() {
        return number;
    }

    public Key insert(Key data) {
        if (number>0 && !data.getClass().equals(heap[1].getClass()) ){
            return null;
        }else {
            number++;
            if (number == heap.length) {
                reSize();
            }
            heap[number] = data;
            swim(number);
            return data;
        }
    }

    public void reSize() {
        Key[] newHeap = (Key[]) new Comparable[number * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        this.heap = newHeap;
    }

    public Key delMax() {
        if (number > 1) {
            Key maxValue = heap[1];
            exchange(1, number);
            heap[number] = null;
            number--;
            sink(1);
            return maxValue;
        } else if (number == 1) {
            Key maxValue = heap[1];
            heap[1] = null;
            number--;
            return maxValue;
        }else{
            return null;
        }
    }

    private void exchange(int index1, int index2) {
        Key temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void swim(int index) {
        while (index >= 1 && index / 2 >= 1 && heap[index / 2].compareTo(heap[index]) < 0) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }

    private void showHeap() {
        System.out.print("Number:" + number + "-");
        for (int i = 0; i <= this.number; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println("");
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
                    }else {
                        exchange(index, leftIndex);
                        index = leftIndex;
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

    public boolean isMaxHeap() {
        int index = 1;
        while (index * 2 <= number) {
            if (heap[index].compareTo(heap[index * 2]) < 0) {
                return false;
            }
            if (index * 2 + 1 <= number && heap[index].compareTo(heap[index * 2 + 1]) < 0) {
                return false;
            }
            index++;
        }
        return true;
    }
}
