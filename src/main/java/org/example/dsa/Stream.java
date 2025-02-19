package org.example.dsa;

import java.util.*;
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


    }
}
