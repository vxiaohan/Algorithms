package com.algorithm.chapter3.searching;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author XiaoHan
 */
public class BinarySearchTreeTest {
    public BinarySearchTree<String, Integer> initTestData(String[] keys, Integer[] values) {
        BinarySearchTree<String, Integer> binarySearchTree = new BinarySearchTree<String, Integer>();
        for (int i = 0; i < keys.length; i++) {
            binarySearchTree.put(keys[i], values[i]);
        }
        return binarySearchTree;
    }

    @Test
    public void testPutAndGetValue() {
        String[] strings = {"a", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        for (int i = 0; i < strings.length; i++) {
            assert binarySearchTree.getValue(strings[i]).equals(integers[i]);
        }
        assert binarySearchTree.getValue("w") == null;
        binarySearchTree.put("a", 10);
        assert binarySearchTree.getValue("a").equals(10);
    }

    @Test
    public void testSize() {
        assert (new BinarySearchTree<String, Integer>()).size() == 0;
        String[] strings = {"a", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.size() == 7;
    }

    @Test
    public void testMinMax() {
        assert (new BinarySearchTree<String, Integer>()).min() == null;
        assert (new BinarySearchTree<String, Integer>()).max() == null;
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.min().equals("b");
        assert binarySearchTree.max().equals("z");
    }

    @Test
    public void testFloorAndCeiling() {
        assert (new BinarySearchTree<String, Integer>()).floor("d") == null;
        assert (new BinarySearchTree<String, Integer>()).ceiling("d") == null;
        String[] strings = {"m", "b", "d", "c", "y", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.floor("c").equals("c");
        assert binarySearchTree.floor("e").equals("d");
        assert binarySearchTree.floor("x").equals("m");
        assert binarySearchTree.floor("a") == null;
        assert binarySearchTree.ceiling("c").equals("c");
        assert binarySearchTree.ceiling("e").equals("g");
        assert binarySearchTree.ceiling("x").equals("y");
        assert binarySearchTree.ceiling("z") == null;
    }

    @Test
    public void testDeleteMin() {
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.size() == 7;
        binarySearchTree.deleteMin();
        assert binarySearchTree.size() == 6;
        assert binarySearchTree.min().equals("c");
        binarySearchTree.deleteMin();
        assert binarySearchTree.size() == 5;
        assert binarySearchTree.min().equals("d");
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        binarySearchTree1.deleteMin();
        assert binarySearchTree1.size() == 0;
        assert binarySearchTree1.min() == null;
        binarySearchTree1.deleteMin();
        assert binarySearchTree1.size() == 0;
        assert binarySearchTree1.min() == null;
    }

    @Test
    public void testDeleteMax() {
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.size() == 7;
        binarySearchTree.deleteMax();
        assert binarySearchTree.size() == 6;
        assert binarySearchTree.max().equals("m");
        binarySearchTree.deleteMax();
        assert binarySearchTree.size() == 5;
        assert binarySearchTree.max().equals("k");
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        assert binarySearchTree1.size() == 1;
        binarySearchTree1.deleteMax();
        assert binarySearchTree1.size() == 0;
        assert binarySearchTree1.max() == null;
        binarySearchTree1.deleteMax();
        assert binarySearchTree1.max() == null;
    }

    @Test
    public void testDelete() {
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.size() == 7;
        binarySearchTree.delete("d");
        assert binarySearchTree.getValue("d") == null;
        assert binarySearchTree.size() == 6;
        binarySearchTree.delete("z");
        assert binarySearchTree.size() == 5;
        assert binarySearchTree.max().equals("m");
        assert binarySearchTree.getValue("z") == null;
        binarySearchTree.delete("c");
        assert binarySearchTree.size() == 4;
        assert binarySearchTree.getValue("c") == null;
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        binarySearchTree1.delete("a");
        assert binarySearchTree1.getValue("a") == null;
        assert binarySearchTree1.size() == 0;
        binarySearchTree1.delete("a");
        assert binarySearchTree1.getValue("a") == null;
        assert binarySearchTree1.size() == 0;
    }

    @Test
    public void testSelection() {
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.selection(1).equals("b");
        assert binarySearchTree.selection(2).equals("c");
        assert binarySearchTree.selection(3).equals("d");
        assert binarySearchTree.selection(4).equals("g");
        assert binarySearchTree.selection(5).equals("k");
        assert binarySearchTree.selection(6).equals("m");
        assert binarySearchTree.selection(7).equals("z");
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        assert binarySearchTree1.selection(1).equals("a");
        binarySearchTree1.delete("a");
        assert binarySearchTree1.selection(1) == null;
    }

    @Test
    public void testRank() {
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.rank("b") == 1;
        assert binarySearchTree.rank("c") == 2;
        assert binarySearchTree.rank("d") == 3;
        assert binarySearchTree.rank("g") == 4;
        assert binarySearchTree.rank("k") == 5;
        assert binarySearchTree.rank("m") == 6;
        assert binarySearchTree.rank("z") == 7;
        assert binarySearchTree.rank(null) == 0;
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        assert binarySearchTree1.rank("a") == 1;
        binarySearchTree1.delete("a");
        assert binarySearchTree1.rank("a") == 0;
    }

    @Test
    public void testKeysPreOrder(){
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        ArrayDeque<String> queue = (ArrayDeque<String>) binarySearchTree.keysPreOrder();
        String[] preOrder = {"m", "b", "d", "c", "k", "g", "z"};
        for (int i=0; i<strings.length; i++){
            assert  queue.pop().equals(preOrder[i]);
        }
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        binarySearchTree1.delete("a");
        queue = (ArrayDeque<String>) binarySearchTree1.keysPreOrder();
        assert queue.size() == 0;
    }

    @Test
    public void testKeysInOrder(){
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        ArrayDeque<String> queue = (ArrayDeque<String>) binarySearchTree.keysInOrder();
        String[] preOrder = {"b", "c", "d", "g", "k", "m", "z"};
        for (int i=0; i<strings.length; i++){
            assert  queue.pop().equals(preOrder[i]);
        }
        String[] strings1 = {"a"};
        Integer[] integers1 = {3};
        BinarySearchTree binarySearchTree1 = initTestData(strings1, integers1);
        binarySearchTree1.delete("a");
        queue = (ArrayDeque<String>) binarySearchTree1.keysInOrder();
        assert queue.size() == 0;
    }
}