package org.example.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueExample<E> {

    private final Comparator<? super E> comparator;
    private final Queue<E> queue;

    public PriorityQueExample(Comparator<? super E> comparator) {
        this.comparator = comparator;
        queue = new PriorityQueue<>(comparator);
    }

    public void addAll(E[] elements) {
        for(E element : elements) {
            queue.offer(element);
        }
    }

    public boolean add(E element) {
        return queue.offer(element);
    }

    public void printAll() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
