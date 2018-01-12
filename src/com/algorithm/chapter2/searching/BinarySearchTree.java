package com.algorithm.chapter2.searching;

import java.util.Stack;

/**
 * @author XiaoHan
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count = 1;

        Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.count;
        }
    }

    public Value getValue(Key key) {
        Node tempSearch = root;
        while (tempSearch != null) {
            int compareResult = tempSearch.key.compareTo(key);
            if (compareResult == 0) {
                return tempSearch.value;
            } else if (compareResult < 0) {
                tempSearch = tempSearch.right;
            } else {
                tempSearch = tempSearch.left;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (this.root == null) {
            root = new Node(key, value, 1);
            return;
        }
        Node tempNode = root;
        Stack<Node> fatherNodesStack = new Stack<Node>();
        int compareResult = 0;
        fatherNodesStack.push(root);
        while (true) {
            if (tempNode == null) {
                Node father = fatherNodesStack.peek();
                if (compareResult < 0) {
                    father.right = new Node(key, value, 1);
                } else {
                    father.left = new Node(key, value, 1);
                }
                break;
            }
            compareResult = tempNode.key.compareTo(key);
            if (tempNode != fatherNodesStack.peek()){
                fatherNodesStack.push(tempNode);
            }
            if (compareResult == 0) {
                tempNode.value = value;
                return;
            } else if (compareResult < 0) {
                tempNode = tempNode.right;
            } else {
                tempNode = tempNode.left;
            }

        }
        // update count value
        while (!fatherNodesStack.isEmpty()) {
            fatherNodesStack.pop().count++;
        }
    }

    public Key min(){
        Node temp = root;
        while (temp != null){
            if (temp.left == null){
                return temp.key;
            }else{
                temp = temp.left;
            }
        }
        return null;
    }

    public Key max(){
        Node temp = root;
        while (temp != null){
            if (temp.right == null){
                return temp.key;
            }else{
                temp = temp.right;
            }
        }
        return null;
    }

    public Key floor(Key key){
        Node temp = root;
        Key floorKey = null;
        while (temp != null){
            if (temp.key.compareTo(key) == 0){
                return temp.key;
            }else if (temp.key.compareTo(key) < 0){
                if (floorKey==null || floorKey.compareTo(temp.key) < 0){
                    floorKey = temp.key;
                }
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return floorKey;
    }

    public Key ceiling(Key key){
        Node temp = root;
        Key ceilingKey = null;
        while (temp != null){
            if (temp.key.compareTo(key) == 0){
                return temp.key;
            }else if (temp.key.compareTo(key) > 0){
                if (ceilingKey==null || ceilingKey.compareTo(temp.key) > 0){
                    ceilingKey = temp.key;
                }
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return ceilingKey;
    }
}


