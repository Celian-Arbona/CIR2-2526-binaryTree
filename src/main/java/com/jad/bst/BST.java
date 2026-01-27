package com.jad.bst;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BST<E> implements IBinaryNode<E> {
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private IBinaryNode<E> root;

    public BST() {
        this.root = null;
    }

    public void addData(final int index, final E data) {
        if (this.root == null) this.root = new BinaryNode<>(index);
        this.root.addData(index, data);
    }

    @Override
    public boolean isIndexExist(final int index) {
        return this.root != null && this.root.isIndexExist(index);
    }

    @Override
    public int getIndex() {
        return (this.root != null) ? this.root.getIndex() : 0;
    }

    @Override
    public List<E> getData() {
        return (this.root != null) ? this.root.getData() : null;
    }

    @Override
    public IBinaryNode<E> getLeft() {
        return this.root;
    }

    @Override
    public void setLeft(final IBinaryNode<E> left) {
        this.root = left;
    }

    @Override
    public IBinaryNode<E> getRight() {
        return this.root;
    }

    @Override
    public void setRight(final IBinaryNode<E> right) {
        this.root = right;
    }

    public IBinaryNode<E> getParent(final int index) {
        if (this.root != null && this.root.getIndex() == index) return this;
        return (this.root != null) ? this.root.getParent(index) : null;
    }

    @Override
    public String toMMDString() {
        return this.root.toMMDString();
    }

    @Override
    public int getHeight() {
        return (this.root == null) ? 0 : this.root.getHeight();
    }

    @Override
    public int getBalancingFactor() {
        return (this.root == null) ? 0 : this.root.getBalancingFactor();
    }

    @Override
    public boolean isBalanced() {
        return this.root == null || this.root.isBalanced();
    }

    @Override
    public IBinaryNode<E> getByIndex(final int index) {
        return (this.root == null) ? null : this.root.getByIndex(index);
    }

    public void toMMDFile(final String fileName) {
        if (this.root == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append("graph TD\n");
        String temp = this.root.getData().toString();
        temp = temp.substring(1, temp.length() - 1);
        sb.append("START -->").append(this.root.getIndex()).append("(").append(this.root.getIndex()).append("-").append(
                temp).append(" = ").append(this.getBalancingFactor()).append(")").append("\n");
        sb.append(this.root.toMMDString());
        sb.append("\n");
//        sb.append("classDef red fill:#ff4d4d,stroke:#b30000,color:#fff;");
//        sb.append("class ");
//        sb.append(" rouge;");
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rotateLeft(final int index) {
        final IBinaryNode<E> parent = this.getParent(index);
        if (parent == null) return;
        final IBinaryNode<E> current = this.getByIndex(index);
        final IBinaryNode<E> right = current.getRight();
        if (parent.getLeft() == current) parent.setLeft(right);
        if (parent.getRight() == current) parent.setRight(right);
        current.setRight((right == null) ? null : right.getLeft());
        if (right != null) right.setLeft(current);
    }

    public void rotateRight(final int index) {
        final IBinaryNode<E> parent = this.getParent(index);
        if (parent == null) return;
        final IBinaryNode<E> current = this.getByIndex(index);
        final IBinaryNode<E> left = current.getLeft();
        if (parent.getLeft() == current) parent.setLeft(left);
        if (parent.getRight() == current) parent.setRight(left);
        current.setLeft((left == null) ? null : left.getRight());
        if (left != null) left.setRight(current);
    }

}
