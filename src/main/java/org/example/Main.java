package org.example;

import org.example.dsa.PriorityQueExample;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) {
   /*     Integer[] arr = new Integer[]{1, 290, 39, 6, 8, 23, 67, 12};
        Comparator<Integer> comparator = (a, b) -> Integer.compare(b, a);
        PriorityQueExample<Integer> priorityQueExample = new PriorityQueExample<>(comparator);
        priorityQueExample.addAll(arr);
        priorityQueExample.printAll();*/

/*
        //Concatenation
        System.out.println("sarvesh " + 3 + 4);
        // inside round brackets will perform operations
        System.out.println("sarvesh " + (3 + 4));

        System.out.println('9' - '0' -  1);
        System.out.println(3 * 3 + 2);

        int counter = 1;
        //Here you are assigning value and not memory address
        int longest = counter;
        counter++;
        counter++;

        System.out.println(counter);
        System.out.println(longest);

        System.out.println(Math.abs(-1));
        int a = -1;
        int b = -2;
        System.out.println(b - a);*/

        /*char c = (char) ('Z' + 32);
        System.out.println("char is :" + c);*/

/*        int k = 3;
        int n = 6;
        k = k % n;
        System.out.println(k);*/


       /* List<String> array = new ArrayList<>();
        array.add("a");
        array.add("b");

        List<String> array2 = List.copyOf(array);
        array2.add("c");

        System.out.println(array);
        System.out.println(array2);*/

        /*List<String> copyOnWrite = new CopyOnWriteArrayList<>();
        copyOnWrite.add("a");
        copyOnWrite.add("b");
        copyOnWrite.add("c");

        for(String element : copyOnWrite) {
            System.out.println(element);
            copyOnWrite.remove(element);
            copyOnWrite.add("d");
        }

        System.out.println(copyOnWrite);*/

        /*int count = 0;
        int max =  count;

        System.out.println(max);
        count++;
        System.out.println(max);*/

        /*int a = 2;
        int b = 2;

        System.out.println(a ^ b ^ 1    );*/


        /*AtomicInteger one = new AtomicInteger(0);   // Default zero
        AtomicInteger two = new AtomicInteger();               // Default zero
        System.out.println(one);
        System.out.println(two);*/


        //Automatic type conversion
        // 2 rules for widening conversion
        //1. target and source data types must be compatible
        //2. target data type must be larger than source data type
       /* byte b = 2;
        short s = 100;
        long l = 1000000000;
        int i = 20000;

        System.out.println(i);*/

        //you can use java keywords but use can use class names
        /*int int = 24;
        char switch = 'i';
        System.out.print(Integer);
        System.out.print(String);*/

       /* short x = 10;
        x =  x * 5;
        System.out.print(x);*/

        /*byte b = 127;
        b++;
        b++;
        b++;
        b++;
        b++;
        System.out.println(b);

        float f = Float.MIN_VALUE;
        f *= 2;
        System.out.println(f);      // Infinity



        char[] c = new char[1];
        int[] i = new int[1];
        System.out.println(i.length);
        int[] i1 = {1, 2, 3};       //also another syntax

        //replaceAll must only be used with regex and replace must be used with strings or chars
        String str1 = "Interviewbit".replaceAll("sdvsghdv","sabdvas");*/

        char d = '4';
        /*System.out.println(d % 2);
        System.out.println((int) d);*/

        //char operations

        //Capital Alphabets to small alphabets
        char evalSmall = 'Z' + 32;
        //Small Alphabets to small Alphabets
        char evalCaps = 'z' - 32;
        //Char to number
        /*int digit = '7' - '0';
        System.out.println("eval small : " + evalSmall);
        System.out.println("eval caps : " + evalCaps);
        System.out.println("digit : " + digit);*/

        /*String flower = "flower";
        System.out.println(flower.substring(0, flower.length()));   // Does not throw out of bound exception because endIndex is exclusive because (n - 1 is valid index);
        System.out.println(flower.substring(0, 7));        // Throw IndexOutOfBoundException if greater than length*/

    }

}

