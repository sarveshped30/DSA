package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {


    public String encode(List<String> arr) {
        StringBuilder builder = new StringBuilder();

        for(String str : arr) {
            builder.append(str.length()).append('#').append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String encodedStr) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < encodedStr.length()) {
            int hashIndex =  encodedStr.indexOf('#', i);
            int length = Integer.parseInt(encodedStr.substring(i, hashIndex));
            String element = encodedStr.substring(hashIndex + 1, hashIndex + 1 + length);
            result.add(element);
            i = hashIndex + 1 + length;
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings =  new EncodeDecodeStrings();

        String[] input = new String[] {"neet","code","love","you"};

        String encodedString = encodeDecodeStrings.encode(Arrays.asList(input));

        System.out.println(encodedString);

        List<String> decodedList = encodeDecodeStrings.decode(encodedString);

        System.out.println(decodedList);
    }
}
