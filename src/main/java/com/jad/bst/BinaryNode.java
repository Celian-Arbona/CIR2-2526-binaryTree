package com.jad.bst;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
public class BinaryNode<E> {
    private final int index;
    private final List<E> data = new ArrayList<>();
    @Setter(AccessLevel.PROTECTED)
    private BinaryNode<E> left;
    @Setter(AccessLevel.PROTECTED)
    private BinaryNode<E> right;

    public BinaryNode(final int index) {
        this.index = index;
        this.left = null;
        this.right = null;
    }

    public void addData(final int index, final E data) {
        if (this.index == index) {
            this.data.add(data);
        } else if (index < this.index) {
            if (this.left == null) this.left = new BinaryNode<>(index);
            this.left.addData(index, data);
        } else {
            if (this.right == null) this.right = new BinaryNode<>(index);
            this.right.addData(index, data);
        }
    }

    public List<E> getDataListByIndex(final int index) {
        if (this.index == index) return new ArrayList<>(this.data);
        return null;
    }

    public boolean isIndexExist(final int index) {
        if (this.index == index) return true;
        if (index < this.index) {
            if (this.left == null) return false;
            return (this.left.isIndexExist(index));
        }
        if (this.right == null) return false;
        return (this.right.isIndexExist(index));
    }

    public String toMMDString() {
        if (this.left == null && this.right == null) return "";
        StringBuilder sb = new StringBuilder();
        if (this.left != null) {
            String temp = this.left.getData().toString();
            temp = temp.substring(1, temp.length() - 1);
            sb.append(this.index).append(" --> ").append(this.left.index).append("(").append(this.left.index).append(
                    "-").append(
                    temp).append(")").append("\n");
            sb.append(this.left.toMMDString());
        }
        if (this.right != null) {
            String temp = this.right.getData().toString();
            temp = temp.substring(1, temp.length() - 1);
            sb.append(this.index).append(" --> ").append(this.right.index).append("(").append(this.right.index).append(
                    "-").append(
                    temp).append(")").append("\n");
            sb.append(this.right.toMMDString());
        }
        return sb.toString();
    }
}
