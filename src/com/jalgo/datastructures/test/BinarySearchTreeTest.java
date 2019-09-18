package com.jalgo.datastructures.test;

import com.jalgo.datastructures.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void construct() {
        BinarySearchTree tree = constructTestTree();
        assertEquals("(1000 (500 (300 (200) (400)) (600 (550) (650))) (2000 (1500) (3000 (4000))))", tree.toString());
        assertEquals("(A (A11 (A21 (A31) (A32)) (A22 (A33) (A34))) (A12 (A23) (A24 (-) (A35))))", tree.toString(true, true));
    }

    @Test
    public void get() {
        BinarySearchTree tree = constructTestTree();
        assertEquals("A11", tree.get(500));
        assertEquals("A23", tree.get(1500));
        assertEquals("A34", tree.get(650));
        assertEquals("A35", tree.get(4000));
    }

    @Test
    public void deleteLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1000, "X");
        tree.add(500, "A");
        tree.add(2000, "B");
        assertEquals("(X (A) (B))", tree.toString(true, true));
        tree.delete(2000);
        assertEquals("(X (A) (-))", tree.toString(true, true));
    }

    @Test
    public void deleteNodeWithOneLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1000, "X");
        tree.add(500, "A");
        tree.add(2000, "B");
        tree.add(300, "A.l");
        tree.add(3000, "B.r");
        assertEquals("(X (A (A.l) (-)) (B (-) (B.r)))", tree.toString(true, true));
        tree.delete(500);
        assertEquals("(X (A.l) (B (-) (B.r)))", tree.toString(true, true));
        tree.delete(2000);
        assertEquals("(X (A.l) (B.r))", tree.toString(true, true));
    }

    @Test
    public void deleteNodeWithoutRightLeftLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1000, "X");
        tree.add(500, "A");
        tree.add(2000, "B");
        tree.add(300, "A.l");
        tree.add(600, "A.r");
        tree.add(650, "A.r.r");
        tree.add(630, "A.r.r.l");
        tree.add(670, "A.r.r.r");
        assertEquals("(X (A (A.l) (A.r (-) (A.r.r (A.r.r.l) (A.r.r.r)))) (B))", tree.toString(true, true));
        tree.delete(500);
        assertEquals("(X (A.r (A.l) (A.r.r (A.r.r.l) (A.r.r.r))) (B))", tree.toString(true, true));
    }

    @Test
    public void deleteNodeWithRightLeftLeaf() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1000, "X");
        tree.add(500, "A");
        tree.add(2000, "B");
        tree.add(300, "A.l");
        tree.add(600, "A.r");
        tree.add(550, "A.r.l");
        tree.add(530, "A.r.l.l");
        tree.add(650, "A.r.r");
        tree.add(630, "A.r.r.l");
        tree.add(670, "A.r.r.r");
        assertEquals("(X (A (A.l) (A.r (A.r.l (A.r.l.l) (-)) (A.r.r (A.r.r.l) (A.r.r.r)))) (B))", tree.toString(true, true));
        tree.delete(500);
        assertEquals("(X (A.r.l.l (A.l) (A.r (A.r.l) (A.r.r (A.r.r.l) (A.r.r.r)))) (B))", tree.toString(true, true));
    }

    @Test
    public void height() {
        assertEquals(4, constructTestTree().getHeight());
    }

    @Test
    public void isBalanced() {
        BinarySearchTree tree = constructTestTree();
        assertEquals(true, tree.isBalanced());
        tree.delete(1500);
        assertEquals(false, tree.isBalanced());
    }

    @Test
    public void traverseLevelOrder() {
        StringBuilder sb = new StringBuilder();
        constructTestTree().traverseLevelOrder(((node, level) -> sb.append(node.getKey()).append(' ')));
        assertEquals("1000 500 2000 300 600 1500 3000 200 400 550 650 4000 ", sb.toString());
    }

    @Test
    public void traversePreOrder() {
        StringBuilder sb = new StringBuilder();
        constructTestTree().traversePreOrder(((node, level) -> sb.append(node.getKey()).append(' ')));
        assertEquals("1000 500 300 200 400 600 550 650 2000 1500 3000 4000 ", sb.toString());
    }

    @Test
    public void traverseInOrder() {
        StringBuilder sb = new StringBuilder();
        constructTestTree().traverseInOrder(((node, level) -> sb.append(node.getKey()).append(' ')));
        assertEquals("200 300 400 500 550 600 650 1000 1500 2000 3000 4000 ", sb.toString());
    }

    @Test
    public void traversePostOrder() {
        StringBuilder sb = new StringBuilder();
        constructTestTree().traversePostOrder(((node, level) -> sb.append(node.getKey()).append(' ')));
        assertEquals("200 400 300 550 650 600 500 1500 4000 3000 2000 1000 ", sb.toString());
    }

    /******************************************************
     1000 "A"
     /            \
     500 "A11"            2000 "A12"
     /         \             /       \
     300 "A21"    600 "A22"   1500 "A23"   3000 "A24"
     /      \      /      \                      \
     200     400    550     650                   4000
     "A31"   "A32"  "A33"   "A34"                  "A35"
     *******************************************************/
    private static BinarySearchTree<Integer, String> constructTestTree() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree();
        tree.add(1000, "A");
        tree.add(500, "A11");
        tree.add(2000, "A12");

        tree.add(300, "A21");
        tree.add(600, "A22");
        tree.add(1500, "A23");
        tree.add(3000, "A24");

        tree.add(200, "A31");
        tree.add(400, "A32");
        tree.add(550, "A33");
        tree.add(650, "A34");
        tree.add(4000, "A35");
        return tree;
    }
}
