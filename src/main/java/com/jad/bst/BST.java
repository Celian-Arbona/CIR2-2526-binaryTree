package com.jad.bst;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;

public class BST<E> {
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private BinaryNode<E> root;

    public BST() {
        this.root = null;
    }

    public void addData(final int index, final E data) {
        if (this.root == null) this.root = new BinaryNode<>(index);
        this.root.addData(index, data);
    }

    public void toMMDFile(final String fileName) {
        if (this.root == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append("graph TD\n");
        String temp = this.root.getData().toString();
        temp = temp.substring(1, temp.length() - 1);
        sb.append("START -->").append(this.root.getIndex()).append("(").append(this.root.getIndex()).append("-").append(
                temp).append(")").append("\n");
        sb.append(this.root.toMMDString());
        sb.append("\n");
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
