package org.example.commons;

public class PairStatic<L, R> {

    private final L left;
    private final R right;

    private PairStatic(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> PairStatic<L, R> pairOf(L left, R right) {
        return new PairStatic<>(left, right);
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
