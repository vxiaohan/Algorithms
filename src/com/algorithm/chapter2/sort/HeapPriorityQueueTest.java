package com.algorithm.chapter2.sort;

public class HeapPriorityQueueTest {
    @org.junit.Test
    public void heapPriorityQueueTest() {
        HeapPriorityQueue heap = new HeapPriorityQueue(7);
        for (int i = 1; i <= 7; i++) {
            heap.insert(i);
        }
        assert heap.size() == 7;
        assert heap.isMaxHeap();
        assert (Integer) heap.delMax() == 7;
        assert heap.size() == 6;
        for (int i = 10; i <= 27; i++) {
            heap.insert(i);
        }
        assert heap.size() == 24;
        assert heap.isMaxHeap();

        HeapPriorityQueue heap2 = new HeapPriorityQueue();
        for (int i = 1; i <= 7; i++) {
            heap2.insert(i);
        }
        assert heap2.size() == 7;
        assert heap2.isMaxHeap();
        assert (Integer) heap2.delMax() == 7;
        assert heap2.size() == 6;
        for (int i = 10; i <= 27; i++) {
            heap2.insert(i);
        }
        assert heap2.size() == 24;
        assert heap2.isMaxHeap();
        for (int i = 1; i <= 100; i++) {
            heap2.delMax();
        }
    }
}