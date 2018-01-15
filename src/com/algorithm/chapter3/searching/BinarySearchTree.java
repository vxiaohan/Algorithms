package com.algorithm.chapter3.searching;

import java.util.ArrayDeque;
import java.util.Queue;
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
        if (root != null) {
            return size(root);
        } else {
            return 0;
        }
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
            if (tempNode != fatherNodesStack.peek()) {
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

    public Key min() {
        Node temp = root;
        while (temp != null) {
            if (temp.left == null) {
                return temp.key;
            } else {
                temp = temp.left;
            }
        }
        return null;
    }

    public Key max() {
        Node temp = root;
        while (temp != null) {
            if (temp.right == null) {
                return temp.key;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public Key floor(Key key) {
        Node temp = root;
        Key floorKey = null;
        while (temp != null) {
            if (temp.key.compareTo(key) == 0) {
                return temp.key;
            } else if (temp.key.compareTo(key) < 0) {
                if (floorKey == null || floorKey.compareTo(temp.key) < 0) {
                    floorKey = temp.key;
                }
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return floorKey;
    }

    public Key ceiling(Key key) {
        Node temp = root;
        Key ceilingKey = null;
        while (temp != null) {
            if (temp.key.compareTo(key) == 0) {
                return temp.key;
            } else if (temp.key.compareTo(key) > 0) {
                if (ceilingKey == null || ceilingKey.compareTo(temp.key) > 0) {
                    ceilingKey = temp.key;
                }
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return ceilingKey;
    }

    public void deleteMin() {
        if (root == null) {
            return;
        }
        Node temp = root;
        Stack<Node> fatherStack = new Stack<Node>();
        fatherStack.push(root);
        while (temp != null) {
            if (temp.left == null) {
                if (temp == root) {
                    root = root.right;
                    return;
                } else {
                    fatherStack.peek().left = temp.right;
                    break;
                }
            } else {
                if (temp != root) {
                    fatherStack.push(temp);
                }
                temp = temp.left;
            }
        }
        while (!fatherStack.isEmpty()) {
            Node tempFather = fatherStack.pop();
            tempFather.count--;
        }
    }

    public void deleteMax() {
        if (root == null) {
            return;
        }
        Node temp = root;
        Stack<Node> fatherStack = new Stack<Node>();
        fatherStack.push(root);
        while (temp != null) {
            if (temp.right == null) {
                if (temp == root) {
                    root = root.left;
                    return;
                } else {
                    fatherStack.peek().right = temp.left;
                    break;
                }
            } else {
                if (temp != root) {
                    fatherStack.push(temp);
                }
                temp = temp.right;
            }
        }
        while (!fatherStack.isEmpty()) {
            Node tempFather = fatherStack.pop();
            tempFather.count--;
        }
    }

    private Node swimToDelete(Node child, Node father) {
        Node tempFather = father;
        while (child.left != null && child.right != null) {
            Node temp = child.left;
            exchange(child.left, child, tempFather);
            tempFather = temp;
        }
        return tempFather;
    }

    private void exchange(Node child, Node father, Node grandFather) {
        Node childLeft = child.left;
        Node childRight = child.right;
        int childCount = child.count;
        if (father.left == child) {
            child.left = father;
            child.right = father.right;
        } else {
            child.right = father;
            child.left = father.left;
        }
        child.count = father.count - 1;
        father.count = childCount;
        father.left = childLeft;
        father.right = childRight;
        if (grandFather != null) {
            if (grandFather.left == father) {
                grandFather.left = child;
            } else {
                grandFather.right = child;
            }
        }
    }

    public void delete(Key key) {
        if (root == null) {
            return;
        }
        Node tempSearch = root;
        Node tempFather = null;
        Stack<Node> fatherStack = new Stack<>();
        while (tempSearch != null) {
            int compareResult = tempSearch.key.compareTo(key);
            if (compareResult == 0) {
                tempFather = swimToDelete(tempSearch, tempFather);
                if (tempFather == null) {
                    root = null;
                } else {
                    if (tempFather.left == tempSearch) {
                        tempFather.left = null;
                    } else {
                        tempFather.right = null;
                    }
                }
                break;
            } else if (compareResult < 0) {
                fatherStack.push(tempSearch);
                tempFather = tempSearch;
                tempSearch = tempSearch.right;
            } else {
                fatherStack.push(tempSearch);
                tempFather = tempSearch;
                tempSearch = tempSearch.left;
            }
        }
        while (!fatherStack.isEmpty()) {
            Node temp = fatherStack.pop();
            temp.count--;
        }
    }

    public Key selection(int k) {
        if (k > size()) {
            return null;
        } else if (k == size()) {
            return max();
        } else {
            Node temp = root;
            int rest = k;
            while (true) {
                if (temp.left == null) {
                    rest--;
                    if (rest == 0) {
                        return temp.key;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    if (temp.left.count < rest - 1) {
                        rest -= temp.left.count + 1;
                        temp = temp.right;
                    } else if (temp.left.count == rest - 1) {
                        return temp.key;
                    } else {
                        temp = temp.left;
                    }
                }
            }
        }
    }

    public int rank(Key key) {
        if (key == null) {
            return 0;
        }
        Node tempSearch = root;
        int rank = 0;
        while (tempSearch != null) {
            int compareResult = tempSearch.key.compareTo(key);
            if (compareResult == 0) {
                if (tempSearch.left != null) {
                    return rank + tempSearch.left.count + 1;
                } else {
                    return rank + 1;
                }
            } else if (compareResult < 0) {
                if (tempSearch.left != null) {
                    rank += tempSearch.left.count + 1;
                } else {
                    rank++;
                }
                tempSearch = tempSearch.right;
            } else {
                tempSearch = tempSearch.left;
            }
        }
        return 0;
    }

    public Iterable<Key> keysPreOrder() {
        Queue<Key> queue = new ArrayDeque<>(size());
        if (root == null) {
            return queue;
        }
        Stack<Node> keys = new Stack<>();
        keys.push(root);
        while (!keys.isEmpty()) {
            Node temp = keys.pop();
            queue.add(temp.key);
            if (temp.right != null) {
                keys.push(temp.right);
            }
            if (temp.left != null) {
                keys.push(temp.left);
            }
        }
        return queue;
    }

    public Iterable<Key> keysInOrder() {
        Queue<Key> queue = new ArrayDeque<>(size());
        if (root == null) {
            return queue;
        }
        Stack<Node> keys = new Stack<>();
        Node p = root;
        while (!keys.isEmpty() || p != null) {
            if (p != null) {
                keys.push(p);
                p = p.left;
            } else {
                p = keys.pop();
                queue.add(p.key);
                p = p.right;
            }
        }
        return queue;
    }
}


