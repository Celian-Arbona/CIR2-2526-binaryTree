package com.jad.binarytree;

import com.jad.Message;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Message> binarySearchTree = new BinarySearchTree<>(
                List.of(
                        new Message(12, "Hello"),
                        new Message(14, "World"),
                        new Message(16, "!"),
                        new Message(1, "This"),
                        new Message(59, "is"),
                        new Message(13, "JAD")
                       )
        );
        System.out.println(binarySearchTree.toPrettyString());
        System.out.println(binarySearchTree.prefix());
        System.out.println(binarySearchTree.infix());
        System.out.println(binarySearchTree.suffix());
        System.out.println(binarySearchTree.byWidth());
        System.out.println(binarySearchTree.getByValue(new Message(89, "")));
    }
}