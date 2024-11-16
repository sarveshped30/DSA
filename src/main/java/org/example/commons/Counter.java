package org.example.commons;

public class Counter {

    public int counter;

    public Counter() {
        this.counter = 0;
    }

    //Only methods are synchronized
    public synchronized void increment() {
        this.counter++;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.sleep();
    }

    //can have both catch and finally
    //or either of two (catch or finally)
    // only try will give compile time exception
    public void sleep() {
        try {
            System.out.println(1/0);
        }catch (Exception e) {
            System.out.println("caught");
        } finally {
            System.out.println("awake");
        }
    }
}
