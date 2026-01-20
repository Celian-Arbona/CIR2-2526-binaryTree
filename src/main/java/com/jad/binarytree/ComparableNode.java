package com.jad.binarytree;

public class ComparableNode<E extends Comparable<E>> extends Node<E> {
    public ComparableNode(final E value) {
        super(value);
    }

    public void add(final E element) {
        final int resultComparison = this.getValue().compareTo(element);
        if (resultComparison == 0) return;
        if (resultComparison > 0) {
            if (this.getLeft() == null) {
                this.setLeft(new ComparableNode<>(element));
            } else {
                ((ComparableNode<E>) this.getLeft()).add(element);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(new ComparableNode<>(element));
            } else {
                ((ComparableNode<E>) this.getRight()).add(element);
            }
        }
    }

    public Node<E> getByValue(final E value) {
        if (value == null) return null;
        final int resultComparison = this.getValue().compareTo(value);
        if (resultComparison == 0) return this;
        if (resultComparison < 0) {
            if (this.getRight() == null) return null;
            return ((ComparableNode<E>) this.getRight()).getByValue(value);
        }
        if (this.getLeft() == null) return null;
        return ((ComparableNode<E>) this.getLeft()).getByValue(value);
    }
}