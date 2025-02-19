package org.example;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        /*int val = 5;
        Optional<Integer> opt = Optional.of(val);
        System.out.println(opt.get());
        Optional<Integer> opt1 = opt.map(i -> i * i);
        System.out.println(opt1.get());

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(2, 3, 4),
                Arrays.asList(5, 6, 7),
                Arrays.asList(8, 9, 10)
        );

        List<List<Integer>> transformedList = list.stream().map(arr -> {
            if(!arr.isEmpty()) {
                for (int i = 0; i < arr.size(); i++) {
                    Integer el = arr.get(i);
                    arr.set(i, el * el);
                }
            }
            return arr;
        }).toList();

        //FlatMap flattens nested data structure
        List<Integer> flattenedList = list.stream().flatMap(List::stream).toList();
        List<Integer> transformedFlattenedList = list.stream().flatMap(arr -> arr.stream().map(i -> i*i)).toList();

        System.out.println(transformedList);
        System.out.println(flattenedList);
        System.out.println(transformedFlattenedList);

        Map<String, Map<String, Integer>> nestedMap = new HashMap<>();
        nestedMap.put("A", Map.of("A1", 1, "A2", 2));
        nestedMap.put("B", Map.of("B1", 3, "B2", 4));

        Map<String, Integer> map = nestedMap.entrySet().stream().flatMap(m -> m.getValue().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);

        opt1.orElse(4);     //Return inside element
        opt.orElseThrow(RuntimeException::new);     //Return inside element or else throws exception
        opt.orElseThrow();     //Return inside element or else throws no such element found exception
        opt.orElseGet(() -> 4); //Return value if present or else supplied value;*/

        int[] inp = new int[]{1, 2, 3, 4, 5};
        //int[] out = new int[inp.length];
        /*int o = 0;
        for(int i : inp) {
            inp[o++] = Double.valueOf(Math.pow(i, 3)).intValue();
        }

        System.out.println(Arrays.toString(inp));*/
        //System.out.println(Arrays.toString(out));


        // so basically when we are deling with arrays of primitive in java 8
        // Arrays.aslIST WONT WORK it will return List<int[]> instead use Array.stream(array).
       /* List<Integer> res = Arrays.stream(inp)
                .boxed()
                .map(x ->Double.valueOf( Math.pow(x, 3)).intValue()).collect(Collectors.toList());

        System.out.println(res);*/

        Integer i = 5;
        Integer j = null;

        //int a = j;
        //So null cannot be instance of integer

        //System.out.println(j instanceof Integer);

        //Long a = 128L;
        Long b = 128L;

        //System.out.println(a == b);

        String str = null;

        //System.out.println(str.toString());

        //System.out.println();

        // 1. ArrayList maintains insertion order
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        System.out.println("ArrayList elements in insertion order: " + arrayList);

        // 2. HashMap does NOT maintain insertion order
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        System.out.println("HashMap elements (unordered): " + hashMap);

        // 3. LinkedHashMap maintains insertion order
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");

        System.out.println("LinkedHashMap elements in insertion order: " + linkedHashMap);

    }

}

