package test1;

import java.util.HashMap;
import java.util.Map;

public class PerumutationsInString {

    public static boolean findPermutation(String value, String pattern) {
        int start=0,end=0,match=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<pattern.length();i++) {
            char chars = pattern.charAt(i);
            map.put(chars, map.getOrDefault(chars,0)+1);

        }

        for(;end<value.length();end++) {
            char chars = value.charAt(end);
            if(map.containsKey(chars)) {
                map.put(chars, map.get(chars)-1);
                if(map.get(chars)==0) {
                    match++;
                }
            }


            if(match == map.size()) {
                return true;
            }

            if(end>=pattern.length()-1) {
                char charStart = value.charAt(start++);
                if(map.containsKey(charStart)) {
                if(map.get(charStart)==0) {
                    match--;
                }

                    map.put(charStart, map.getOrDefault(chars,0)+1);
                }

            }
         }
        return false;
    }
public static void main(String args[]) {
    System.out.println("Permutation exist: "
            + PerumutationsInString.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: "
            + PerumutationsInString.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: "
            + PerumutationsInString.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: "
            + PerumutationsInString.findPermutation("aaacb", "abc"));
}
}
