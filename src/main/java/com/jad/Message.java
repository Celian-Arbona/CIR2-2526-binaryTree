package com.jad;

public record Message(Integer index, String value) implements Comparable<Message> {
    @Override
    public int compareTo(final Message other) {
        return this.index.compareTo(other.index);
    }

    @Override
    public String toString() {
        return this.value + "(" + this.index + ")";
    }
}
