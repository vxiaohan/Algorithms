package com.algorithm.chapter2.searching;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author XiaoHan
 */
public class BinarySearchTreeTest {
    public BinarySearchTree<String, Integer> initTestData(String[] keys, Integer[] values){
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
    public void testSize(){
        assert (new BinarySearchTree<String, Integer>()).size() == 0;
        String[] strings = {"a", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.size() == 7;
    }

    @Test
    public void testMinMax(){
        assert (new BinarySearchTree<String, Integer>()).min() == null;
        assert (new BinarySearchTree<String, Integer>()).max() == null;
        String[] strings = {"m", "b", "d", "c", "z", "k", "g"};
        Integer[] integers = {1, 20, 13, 42, 57, 16, 7};
        BinarySearchTree binarySearchTree = initTestData(strings, integers);
        assert binarySearchTree.min().equals("b");
        assert binarySearchTree.max().equals("z");
    }

    @Test
    public void testFloorAndCeiling(){
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
}