package org.example.commons;

public class Pair <L, R> {

    private L left;
    private R right;

    public Pair() {

    }

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public Pair<L, R> pairOf(L left, R right) {
        return new Pair<>(left, right);
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}

