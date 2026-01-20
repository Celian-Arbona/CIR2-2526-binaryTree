package com.jad;

import com.jad.binarytree.BinarySearchTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>(List.of(12, 14, 16, 1, 59, 13));

        System.out.println(binaryTree.toPrettyString());
        System.out.println(binaryTree.prefix());
        System.out.println(binaryTree.infix());
        System.out.println(binaryTree.suffix());
        System.out.println(binaryTree.byWidth());
    }
}