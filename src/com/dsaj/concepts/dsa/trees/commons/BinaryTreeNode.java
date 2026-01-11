package com.dsaj.concepts.dsa.trees.commons;

public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left = null;
    private BinaryTreeNode<T> right = null;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode<T> leftChild() {
        return this.left;
    }

    public BinaryTreeNode<T> rightChild() {
        return this.right;
    }

    public T getData() {
        return this.data;
    }

    public BinaryTreeNode<T> setLeftChild(BinaryTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<T> setRightChild(BinaryTreeNode<T> right) {
        this.right = right;
        return this;
    }
}
