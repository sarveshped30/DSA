package org.example.commons;


import java.util.Arrays;

public interface Vehicle {


    //These extension methods like default can only be use in interfaces
    // And by default access modifier is public
    default void start() {
        System.out.println("Engine started...");

    }
}
