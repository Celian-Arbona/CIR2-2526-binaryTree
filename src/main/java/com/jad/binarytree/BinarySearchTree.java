package com.jad.binarytree;

import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public BinarySearchTree(final List<E> values) {
        super(values);
    }

    @Override
    protected Node<E> buildNodesFromList(final List<E> values, final int index) {
        final ComparableNode<E> root = new ComparableNode<>(values.getFirst());
        for (E element : values) {
            root.add(element);
        }
        return root;
    }

    public Node<E> getByValue(final E value) {
        if (value == null || this.getRoot() == null) return null;
        return ((ComparableNode<E>) this.getRoot()).getByValue(value);
    }
}
