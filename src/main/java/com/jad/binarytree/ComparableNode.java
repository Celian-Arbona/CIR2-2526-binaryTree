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
}