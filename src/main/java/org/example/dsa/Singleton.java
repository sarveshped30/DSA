package org.example.dsa;

public class Singleton {

    private static Singleton INSTANCE;


    private Singleton() {

    }


    public static Singleton getInstance()  {

        synchronized(Singleton.class) {

            if(INSTANCE == null) {
                INSTANCE = new Singleton();
            }

        }

        return INSTANCE;

    }
}
