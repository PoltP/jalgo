package com.jalgo.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<TKey extends Comparable, TValue> {
    private Node<TKey, TValue> root;

    public Node<TKey, TValue> getRoot() {
        return this.root;
    }

    public TValue get(TKey key) {
        Node<TKey, TValue> node = root;
        while (node != null) {
            int comparison = key.compareTo(node.key);
            if (comparison != 0) {
                node = (comparison < 0) ? node.left : node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public void add(TKey key, TValue value) {
        if (this.root != null) {
            Node<TKey, TValue> node = this.root, parentNode = null;
            while (node != null) {
                int comparison = key.compareTo(node.key);
                if (comparison != 0) {
                    parentNode = node;
                    node = (comparison < 0) ? node.left : node.right;
                } else {
                    node.value = value;
                    return;
                }
            }
            parentNode.addChild(new Node<TKey, TValue>(key, value));
        } else {
            this.root = new Node<TKey, TValue>(key, value);
        }
    }

    public void delete(TKey key) {
        Node<TKey, TValue> node = this.root, parentNode = null;
        while (node != null) {
            int comparison = key.compareTo(node.key);
            if (comparison != 0) {
                parentNode = node;
                node = (comparison < 0) ? node.left : node.right;
            } else {
                break;// 'node' has been found
            }
        }
        if (node == null) {
            return;
        }
        if (node.right == null) {
            if (parentNode == null) {
                this.root = node.left;
            } else {
                // node.left == null || node.left != null
                if (node == parentNode.left) {
                    parentNode.left = node.left;
                } else {
                    parentNode.right = node.left;
                }
            }
        } else {
            Node<TKey, TValue> leftMostNode = node.right;
            parentNode = null;
            while (leftMostNode.left != null) {
                parentNode = leftMostNode;
                leftMostNode = leftMostNode.left;
            }
            if (parentNode != null) {
                parentNode.left = leftMostNode.right;
            } else {// no left child for node.right
                node.right = leftMostNode.right;
            }
            node.key = leftMostNode.key;
            node.value = leftMostNode.value;
        }
    }

    public void traverseLevelOrder(ITraverser<TKey, TValue> traverser) {
        Queue<Node<TKey, TValue>> nodes = new LinkedList<>();
        nodes.offer(this.root);
        int level = 0;
        while (!nodes.isEmpty()) {
            Node<TKey, TValue> node = nodes.poll();
            traverser.traverse(node, level);
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
    }

//    public void traversePreOrderNonrecursive(ITraverser<TKey, TValue> traverser) {
//        Stack<Node<TKey, TValue>> nodes = new Stack<>();
//        nodes.push(this.root);
//        while (!nodes.isEmpty()) {
//            Node<TKey, TValue> node = nodes.pop();
//            traverser.traverse(node);
//            if (node.right != null) {
//                nodes.push(node.right);
//            }
//            if (node.left != null) {
//                nodes.push(node.left);
//            }
//        }
//    }

    public void traversePreOrder(ITraverser<TKey, TValue> traverser) {
        this.traversePreOrder(this.root, traverser, 0);
    }


    public void traverseInOrder(ITraverser<TKey, TValue> traverser) {
        this.traverseInOrder(this.root, traverser, 0);
    }


    public void traversePostOrder(ITraverser<TKey, TValue> traverser) {
        this.traversePostOrder(this.root, traverser, 0);
    }


    public int getHeight() {
        return this.getHeight(this.root);
    }


    public boolean isBalanced() {
        return this.isBalanced(this.root);
    }


    @Override
    public String toString() {
        return this.toString(this.root, false, false);
    }

    public String toString(boolean showEmpty, boolean useValue) {
        return this.toString(this.root, showEmpty, useValue);
    }

    private void traversePreOrder(Node<TKey, TValue> node, ITraverser<TKey, TValue> traverser, int level) {
        if (node == null) {
            return;
        }
        traverser.traverse(node, level);
        this.traversePreOrder(node.left, traverser, level + 1);
        this.traversePreOrder(node.right, traverser, level + 1);
    }

    private void traverseInOrder(Node<TKey, TValue> node, ITraverser<TKey, TValue> traverser, int level) {
        if (node == null) {
            return;
        }
        this.traverseInOrder(node.left, traverser, level + 1);
        traverser.traverse(node, level);
        this.traverseInOrder(node.right, traverser, level + 1);
    }

    private void traversePostOrder(Node<TKey, TValue> node, ITraverser<TKey, TValue> traverser, int level) {
        if (node == null) {
            return;
        }
        this.traversePostOrder(node.left, traverser, level + 1);
        this.traversePostOrder(node.right, traverser, level + 1);
        traverser.traverse(node, level);
    }

    private int getHeight(Node<TKey, TValue> node) {
        if (node == null)
            return 0;
        else {
            return Math.max(this.getHeight(node.left), this.getHeight(node.right)) + 1;
        }
    }

    private boolean isBalanced(Node<TKey, TValue> node) {
        if (node == null)
            return true;
        else {
            return this.isBalanced(node.left) && this.isBalanced(node.right) &&
                    Math.abs(this.getHeight(node.left) - this.getHeight(node.right)) <= 1;
        }
    }

    private String toString(Node<TKey, TValue> node, boolean showEmpty, boolean useValue) {
        if (node == null) return "(-)";
        String str = '(' + (useValue ? node.value : node.key).toString();
        showEmpty = showEmpty && !node.isLeaf();
        if (showEmpty || node.left != null) {
            str += ' ' + toString(node.left, showEmpty, useValue);
        }
        if (showEmpty || node.right != null) {
            str += ' ' + toString(node.right, showEmpty, useValue);
        }
        return str + ')';
    }


    public static class Node<TKey extends Comparable, TValue> {
        TKey key;
        TValue value;
        Node<TKey, TValue> left;
        Node<TKey, TValue> right;

        public TKey getKey() {
            return this.key;
        }

        public TValue getValue() {
            return this.value;
        }

        public Node(TKey key) {
            this(key, null);
        }

        public Node(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        public void addChild(Node<TKey, TValue> node) {
            if (node == null) return;
            if (this.key.compareTo(node.key) < 0) {
                this.right = node;
            } else {
                this.left = node;
            }
        }
    }

    public interface ITraverser<TKey extends Comparable, TValue> {
        void traverse(Node<TKey, TValue> node, int level);
    }
}
