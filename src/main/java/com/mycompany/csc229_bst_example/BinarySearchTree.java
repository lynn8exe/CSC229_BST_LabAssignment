package com.mycompany.csc229_bst_example;
/**
 *
 * @author AdriannaLambert
 */
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
    // ToDo 1: complete InOrder Traversal CHECK

        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
    }


    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal .
    }

    // You need to create this separate private method:
    private void doPreOrder(BstNode root) {
        if (root == null) return;

        System.out.print(root.getData() + " ");
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        return findHeight(this.root);
    }

    private Integer findHeight(BstNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findHeight(node.getLeft());
        int rightHeight = findHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node
        int depth = 0;
        BstNode current = this.root;

        while (current != null) {
            // if node is found return depth
            if (node.getData().equals(current.getData())) {
                return depth;
            }

            //smaller - Left, bigger - Right.
            if (node.getData() < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            depth++;
        }
        return -1;
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {

            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData());
            String nextPrefix = prefix + (isLeft ? "|   " : "    ");

            print(nextPrefix, node.getLeft(), true);
            print(nextPrefix, node.getRight(), false);

        }
    }

}