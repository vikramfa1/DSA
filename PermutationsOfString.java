package test1;

import java.util.HashMap;
import java.util.Map;

public class PermutationsOfString {

    private static boolean isPermutationPresent(String val, String pattern) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0;i<pattern.length();i++) {
            charMap.put(pattern.charAt(i), charMap.getOrDefault(pattern.charAt(i),0)+1);
        }

        int windowStart = 0;
        int match=0;
        for(int windowEnd=0;windowEnd<val.length();windowEnd++) {
            char letter = val.charAt(windowEnd);
            if(charMap.containsKey(letter)) {
                charMap.put(letter, charMap.get(letter)-1);
                if(charMap.get(letter) ==0) {
                    match++;
                }
            }
            if(charMap.size()==match) {
                System.out.println("match: "+match+","+charMap.toString());
                return true;
            }

            if(windowEnd>=pattern.length()-1) {
                char start = val.charAt(windowStart);
                if (charMap.containsKey(start)) {
                    if (charMap.get(start) == 0) {
                        match--;
                    }

                    charMap.put(start, charMap.getOrDefault(start, 0) + 1);
                }
                windowStart++;
            }
        }
        return false;
    }
    public static void main(String args[]) {

        String val ="bcdxabcdy";
        String pattern="bcdyabcdx";
        boolean res = isPermutationPresent(val, pattern);
        System.out.println("resu: "+res);
    }

}
