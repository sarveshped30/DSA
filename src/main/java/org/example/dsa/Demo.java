package org.example.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {


    public static void main(String[] args) {
       String input =  "the quick brown fox jumps over the lazy dog the fox is quick";

        String[] arr = input.trim().split("\\s+");

        //Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        //System.out.println(map);


        /*Input: [[3, 5, 2], [1, 2, 3], [4, 5]]

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(3, 5, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5)
        );

        Output: [1, 2, 3, 4, 5]*/

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(3, 5, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5)
        );

        List<Integer> integerList = nestedLists.stream().flatMap(List::stream).distinct().sorted().toList();
        //System.out.println(integerList);


        /*[ -2, 3, -1, 2, -1, 2, -3 ]

        output: 5 (Maximum continuous subarray sum)  [3, -1, 2, -1, 2])*/

        int[] arr1 = new int[]{-2, 3, -1, 2, -1, 2, -3};

        System.out.println(Demo.maxContinuousSubArraySum(arr1));

        String a = "hello";
        String b = new String("hello");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        List<String> list = Arrays.asList("apple", "banana", "apple","orange");
        String result = list.stream()
                .distinct().sorted()
                .reduce("", (s2, s1) -> s2 + s1);

        System.out.println(result);

    }


    public static int maxContinuousSubArraySum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum < 0) sum = 0;

            max = Math.max(max, sum);
        }

        return max;
    }
}
