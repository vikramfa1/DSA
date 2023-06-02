package test1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKCharacters {

    private static int findLongestSubstring(String str, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int windowStart=0;
        int maxLeng = Integer.MIN_VALUE;
        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {

            char val = str.charAt(windowEnd);
            charMap.put(val, charMap.getOrDefault(val,0)+1);
            while(charMap.size()>k) {


                if(charMap.containsKey(str.charAt(windowStart))) {
                    charMap.put(str.charAt(windowStart), charMap.getOrDefault(str.charAt(windowStart),0)-1);
                }
                if(charMap.get(str.charAt(windowStart))<=0) {
                    charMap.remove(str.charAt(windowStart));
                }
                windowStart++;
            }
            int len = windowEnd - windowStart+1;
            maxLeng = Math.max(maxLeng, len);

        }
        return maxLeng;
    }
    public static void main(String args[]) {
        String s = "ecebaa";
        int k = 2;
        System.out.println("result: "+findLongestSubstring(s, k));
    }
}
