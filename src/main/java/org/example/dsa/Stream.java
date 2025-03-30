package org.example.dsa;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {


    public List<Integer> evenNumber(List<Integer> nums) {
        return nums.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
    }

    public List<String> uppercase(List<String> names) {
        return names.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public Integer firstElGtThen(List<Integer> nums, int n) {
        Optional<Integer> num = nums.stream().filter(e -> e > n).findFirst();
        return num.orElseThrow(() -> new NoSuchElementException("There is no first number in the list"));
    }

    /*public List<Integer> sortDesc(List<Integer> numbers) {
        return numbers.stream().sorted(Collections.reverseOrder(Comparator.comparing(Integer::intValue))).collect(Collectors.toList());
    }*/

    public List<Integer> sortDesc(List<Integer> numbers) {
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> sortAsc(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    public long countStrLengthGreaterThanN(List<String> words, int n) {
        return words.stream().filter(i -> i.length() > n).count();
    }

    public Map<String, List<Integer>> groupEvenOdd(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
    }

    public int max(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        return max.orElseThrow(() -> new NoSuchElementException("No max element found.."));
    }

    public Map<String, Integer> mapWithLength(List<String> words) {
        return words.stream().collect(Collectors.toMap(w -> w, w -> w.length()));
    }

    public String join(List<String> words) {
        return words.stream().collect(Collectors.joining(", "));
    }

    public Integer secondLargest(List<Integer> nums) {
        Optional<Integer> secondLargest = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        return secondLargest.orElseThrow(() -> new NoSuchElementException("No secondLargest element found.."));
    }

    public List<Integer> flatten(List<List<Integer>> nestedList) {
        return nestedList.stream().flatMap(List::stream).toList();
    }

    //String chars returns all the chars int values in a stream
    public Map<Character, Long> freqChars(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public Map<Character, Integer> freqCharsV2(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public int sum(List<Integer> arr) {
        return arr.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    public int sumv2(List<Integer> arr) {
        return arr.stream().mapToInt(Integer::intValue).sum();
    }




    public static void main(String[] args) {

        Stream s = new Stream();

        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(s.evenNumber(num1));

        List<String> names = Arrays.asList("john", "jane", "doe");
        System.out.println(names);

        List<Integer> num2 = Arrays.asList(5, 8, 12, 19, 3);
        System.out.println(s.firstElGtThen(num2, 3));

        List<Integer> numbers = Arrays.asList(5, 8, 12, 19, 3);

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println(s.mapWithLength(words));

        String input = "hello";
        System.out.println(s.freqChars(input));
        System.out.println(s.freqCharsV2(input));


        //Question a wissen tech round3, from sorted array trim duplicates more than 3
        ArrayList<Integer> list = new ArrayList<>();

        int[] arr1 = {1, 2, 2, 2, 3, 4, 4, 4, 4, 5, 7, 7, 7, 7, 7};

        IntStream.of(arr1).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet().stream()
                .forEach(e -> {
                    long v = e.getValue();
                    if(v > 3) {
                        v = 3;
                    }

                    for(int i = 0; i < v; i++) {
                        list.add(e.getKey());
                    }
                });

        System.out.println(list);

        /*int[] arrr = {1, 2, 3, 4};
        char[] charr = {'q', 'e'};

        java.util.stream.Stream.of(charr);*/

/*        List<int[]> arr = new ArrayList<>();

        arr.add(new int[]{1, 2});
        arr.add(new int[]{1, 2, 4});
        arr.add(new int[]{1, 2, 3});*/


    }

    //Write a Java program to calculate the average of a list of integers using streams.
    public double average(List<Integer> nums) {
        return nums.stream().mapToDouble(a -> a).average().orElse(0.0D);
    }

    //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
    public List<String> uppercaseV2(List<String> strs) {
        return strs.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    //Write a Java program to remove all duplicate elements from a list using streams.
    public List<Integer> removeDuplicates(List<Integer> nums) {
        return nums.stream().distinct().collect(Collectors.toList());
    }

    //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    public long countStartingWith(List<String> strs, String prefix) {
        return strs.stream().filter(i -> i.startsWith(prefix)).count();
    }

    //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    public List<String> sortListAsc(List<String> strs) {
        return strs.stream().sorted().collect(Collectors.toList());
    }

    public List<String> sortListDesc(List<String> strs) {
        return strs.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    //Write a Java program to find the maximum and minimum values in a list of integers using streams.
    public Integer minV2(List<Integer> nums) {
        return nums.stream().sorted().findFirst().orElseThrow(() -> new NoSuchElementException("No minimum element found.."));
    }

    public Integer minV3(List<Integer> nums) {
        return nums.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public Integer minV4(List<Integer> nums) {
        return nums.stream().min(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("No minimum element found.."));
    }

    public Integer minV5(List<Integer> nums) {
        return nums.stream().mapToInt(a -> a).min().orElseThrow(() -> new NoSuchElementException("No minimum element found.."));
    }

    public Integer maxV2(List<Integer> nums) {
        return nums.stream().sorted(Comparator.reverseOrder()).findFirst().orElseThrow(() -> new NoSuchElementException("No maximum element found.."));
    }

    public Integer maxV3(List<Integer> nums) {
        return nums.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public Integer maxV4(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("No maximum element found.."));
    }

    public Integer maxV5(List<Integer> nums) {
        return nums.stream().mapToInt(a -> a).max().orElseThrow(() -> new NoSuchElementException("No maximum element found.."));
    }


    //Write a Java program to find the second smallest and largest elements in a list of integers using streams.
    public Integer secondLargestV2(List<Integer> nums) {
        return nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow(() -> new NoSuchElementException("No secondLargest element found.."));
    }

    //Map<Employee, Department> in java, sort the map by Department using java 8 streams

    public Map<String , Integer> sortMap(Map<String, Integer> entries) {
        return entries.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }



}
