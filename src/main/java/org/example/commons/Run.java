package org.example.commons;

import java.util.HashMap;
import java.util.Map;

public class Run {


    public static void main(String[] args) {

        //Code for handle two data types
        /*Pair<String, Integer> pair = new Pair<>("Sarvesh", 3001);

        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());

        PairStatic<Integer, String> pairStatic = PairStatic.pairOf( 1, "Sarvesh");
        System.out.println(pairStatic.getLeft());
        System.out.println(pairStatic.getRight());

        // Like this we can find index of alphabets
        System.out.println('d' - 'a');

        String name = "sarvesh";

        for(char c : name.toCharArray()) {
            System.out.println(c);
        }

        Map<Character, Integer> map = new HashMap();
        map.put('s', 1);
        map.put('a', 1);
        map.put('d', 2);


        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        System.out.println(AccountType.SAVINGS_ACCOUNT.getType());
        System.out.println(AccountType.CURRENT_ACCOUNT.name());         //Name comes from Enums abstract class
    }


    public int[] sum() {
        return new int[]{2, 3};
    }
}
