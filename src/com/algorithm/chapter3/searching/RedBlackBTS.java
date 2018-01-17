package com.algorithm.chapter3.searching;

import java.util.Stack;

/**
 * @author XiaoHan
 */
public class RedBlackBTS<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;
        boolean color;

        Node(Key key, Value value, Node left, Node right, int count, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.count = count;
            this.color = color;
        }
        void flipColors(){
            color = !color;
        }
    }

    boolean isRed(Node node) {
        if (node == null) {
            return false;
        } else {
            return node.color == RED;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null){
            return 0;
        }else {
            return node.count;
        }
    }

    private Node rotateLeft(Node leftNode) {
        Node rightNode = leftNode.right;
        leftNode.right = rightNode.left;
        rightNode.left = leftNode;
        rightNode.color = leftNode.color;
        leftNode.color = RED;
        rightNode.count = leftNode.count;
        leftNode.count = 1 + size(leftNode.left) + size(leftNode.right);
        return rightNode;
    }

    private Node rotateRight(Node rightNode) {
        Node leftNode = rightNode.left;
        rightNode.left = leftNode.right;
        leftNode.right = rightNode;
        leftNode.color = rightNode.color;
        rightNode.color = RED;
        leftNode.count = rightNode.count;
        rightNode.count = 1 + size(rightNode.left) + size(rightNode.right);
        return leftNode;
    }

    public void insert(Key key, Value value) {
        if (root == null) {
            root = new Node(key, value, null, null, 1, BLACK);
            return;
        }
        Stack<Node> fathers = new Stack<>();
        Node temp = root;
        while (true) {
            if (key.compareTo(temp.key) == 0) {
                temp.value = value;
                return;
            } else if (key.compareTo(temp.key) < 0) {
                if (temp.left == null){

                }else {
                    fathers.push(temp);
                    temp = temp.left;
                }
            } else {
                fathers.push(temp);
                temp = temp.right;
            }
        }
    }

}
