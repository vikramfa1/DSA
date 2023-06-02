package test1;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringWithPattern {

    public static String findSubstring(String val, String pattern) {
         int start=0;int match=0;int minLength=Integer.MAX_VALUE;int subStrIndex=0;
         Map<Character, Integer> map = new HashMap<>();
         for(char chars: pattern.toCharArray()) {
             map.put(chars, map.getOrDefault(chars, 0)+1);
         }
         for(int end=0;end<val.length();end++) {
             char endChar = val.charAt(end);
             map.put(endChar, map.getOrDefault(endChar, 0)-1);
             if(map.get(endChar)>=0) {
                 match++;
             }

             while(match == pattern.length()) {

                 if(minLength>end-start+1) {
                     minLength = end-start+1;
                     subStrIndex = start;
                 }

                 char startChar = val.charAt(start++);
                 if(map.containsKey(startChar)) {
                     if(map.get(startChar)==0) {
                         match--;
                     }
                     map.put(startChar, map.getOrDefault(startChar,0)+1);
                 }

             }
         }
         return minLength>val.length()?"":val.substring(subStrIndex, subStrIndex+minLength);
    }
    public static void main(String args[]) {
        System.out.println(ShortestSubstringWithPattern.findSubstring("aabdec", "abc"));
        System.out.println(ShortestSubstringWithPattern.findSubstring("aabdec", "abac"));
        System.out.println(ShortestSubstringWithPattern.findSubstring("abdbca", "abc"));
        System.out.println(ShortestSubstringWithPattern.findSubstring("adcad", "abc"));
    }
}
