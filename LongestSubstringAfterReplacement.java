package test1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAfterReplacement {

    public static int findLength(String value, int k){
        int start=0;int maxLength=0;
        int maxDup=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end=0;end<value.length();end++) {
            char val = value.charAt(end);
            map.put(val, map.getOrDefault(val, 0)+1);
                maxDup = Math.max(maxDup, map.get(val));
            System.out.println("start: "+ value.substring(start,end+1)+","+maxDup+","+start+","+end);
            if(end-start+1-maxDup>k) {
                System.out.println("if: "+start+","+end);
                char val1 = value.charAt(start++);
                map.put(val1, map.getOrDefault(val1, 0)-1);
            }
            System.out.println("end: "+value.substring(start,end+1)+","+maxDup);
            maxLength = Math.max(maxLength, end-start+1);
        }
        return  maxLength;
    }
    public static void main(String args[]) {
        System.out.println(LongestSubstringAfterReplacement.findLength("aabcdbb", 2));
        System.out.println(LongestSubstringAfterReplacement.findLength("abbcb", 1));
        System.out.println(LongestSubstringAfterReplacement.findLength("abccde", 1));
    }
}
