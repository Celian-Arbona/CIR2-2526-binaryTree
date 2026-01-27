package com.jad;

import com.jad.bst.BST;

public class Main {
    public static void main(String[] args) {
        BST<String> bst = new BST<>();
        bst.addData(4, "Mimi");
        bst.addData(3, "Titi");
        bst.addData(1, "Tata");
        bst.addData(2, "Tete");
        bst.addData(10, "CraCra");
        bst.addData(8, "RhoRho");
        bst.addData(9, "Nini");


        bst.addData(6, "Tutu");
        bst.addData(7, "Mama");
        bst.addData(5, "Toto");
        bst.toMMDFile("bst.mmd");
        System.out.println(bst.getHeight());

        bst.rotateRight(4);
        bst.rotateLeft(3);
        bst.toMMDFile("bst2.mmd");

    }
}