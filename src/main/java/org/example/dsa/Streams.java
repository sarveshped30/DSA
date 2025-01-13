package org.example.dsa;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        //1. Filter even numbers from a list of integers:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> even = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

        //2. Convert a list of strings to uppercase:
        List<String> names = Arrays.asList("john", "jane", "doe");
        List<String> caps = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(caps);

        //3. Find the first element greater than 10 in a list:
        List<Integer> nums = Arrays.asList(5, 8, 12, 19, 3);
        Integer n = nums.stream().filter(i -> i > 10).findFirst().orElseThrow(() -> new NoSuchElementException("No Element Found"));
        System.out.println(n);

        //4. Sort a list of integers in descending order:
        List<Integer> nums1 = Arrays.asList(5, 8, 12, 19, 3);
        List<Integer> descSort = nums1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(descSort);

        //5. Remove duplicates from a list:
        List<Integer> nums2 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniques = nums2.stream().distinct().collect(Collectors.toList());
        System.out.println(uniques);

        //6. Count the number of strings with length greater than 3:
        List<String> words = Arrays.asList("cat", "elephant", "dog", "tiger");
        long wordsGt3Count = words.stream().filter(w -> w.length() > 3).count();
        System.out.println(wordsGt3Count);

        //7. Group a list of integers into even and odd numbers:
        List<Integer> num3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, List<Integer>> evenOddGroup = num3.stream()
                .collect(Collectors.groupingBy(i -> (i % 2 == 0) ? "even" : "odd"));
        System.out.println(evenOddGroup);

        //8. Find the maximum number in a list:
        List<Integer> nums4 = Arrays.asList(10, 20, 30, 40, 50);
        int maxNum = nums4.stream().max(Integer::compare).get();
        System.out.println(maxNum);

        //9. Create a map from a list of strings (key: string, value: length):
        List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> map = words1.stream().collect(Collectors.toMap(w -> w, String::length));
        System.out.println(map);

        //10. Join all strings in a list with a comma separator:
        List<String> words2 = Arrays.asList("apple", "banana", "cherry");
        String wordsJoin = words2.stream().collect(Collectors.joining(", "));
        System.out.println(wordsJoin);

        //11. Find the second largest number in a list:
        List<Integer> nums5 = Arrays.asList(10, 20, 30, 40, 50);
        int secondLargest = nums5.stream().sorted(Comparator.reverseOrder()).skip(1)
                .findFirst().orElseThrow(() -> new NoSuchElementException("No Element Found"));
        System.out.println(secondLargest);

        //12. Flatten a list of lists into a single list:
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flatList = nestedLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);

        //13. Find the frequency of each character in a string:
        String input = "hello";
        Map<Character, Long> map2 = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map2);

        Map<Character, Long> map3 = IntStream.range(0, input.length()).mapToObj(input::charAt).collect(Collectors.groupingBy(c -> c,  Collectors.counting()));
        System.out.println(map3);

        //14. Find the first non-repeated character in a string:
        String input1 = "swiss";
        IntStream.range(0, input1.length()).mapToObj(input1::charAt)
                        .filter(c -> input1.indexOf(c) == input1.lastIndexOf(c)).findFirst().ifPresent(System.out::println);

        //15. Calculate the sum of squares of numbers in a list:
        List<Integer> nums6 = Arrays.asList(1, 2, 3, 4);
        int sum = nums6.stream().map(a -> a * a).reduce(0, Integer::sum);
        System.out.println(sum);

        //16. Partition a list of strings into palindromes and non-palindromes:
        List<String> words3 = Arrays.asList("level", "world", "radar", "java");
        Map<Boolean, List<String>> partitioned = words3.stream()
                .collect(Collectors.partitioningBy(word ->
                        word.equals(new StringBuilder(word).reverse().toString())));
        System.out.println(partitioned);

        //17. Find all employees earning more than 50,000 and sort them by name:
        List<Employee> employees = Arrays.asList(
                new Employee("John", 40000),
                new Employee("Jane", 60000),
                new Employee("Doe", 50000)
        );
        List<Employee> filtered = employees.stream().filter(emp -> emp.salary > 50000)
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(filtered);

        //19. Find the average of numbers in a list:
        List<Integer> num7 = Arrays.asList(10, 20, 30, 40);
        num7.stream().mapToInt(b -> b).average().ifPresent(System.out::println);

        String input2 = "hello";
        Map<Character, Long> map4 = IntStream.range(0, input2.length()).mapToObj(input::charAt)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map4);

        //Find second non-repeating character
        String input3 = "swiss";
        IntStream.range(0, input3.length()).mapToObj(input3::charAt)
                .filter(c -> input3.indexOf(c) == input3.lastIndexOf(c))
                .skip(1).findFirst().ifPresent(System.out::println);

    }

}

class Employee {

    String name;
    Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
}
