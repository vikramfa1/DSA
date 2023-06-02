package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {

    public static int findMaxLengthSubstring(String val) {
        int start=0; int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int end=0;end<val.length();end++) {

            char rVal = val.charAt(end);
            freqMap.put(rVal, freqMap.getOrDefault(rVal,0)+1);

            while(freqMap.get(rVal)>1) {
                char lVal = val.charAt(start);
                freqMap.put(lVal,freqMap.getOrDefault(lVal, 0)-1);
                start++;
            }

            maxLength  = Math.max(maxLength , end-start+1);
        }
        return maxLength;
    }

    public static int findMaxLengthSubstring1(String val) {
        int start=0; int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int end=0;end<val.length();end++) {

            char rVal = val.charAt(end);


            if(freqMap.containsKey(rVal)) {
                start = Math.max(start, freqMap.get(rVal)+1);
                System.out.println("char, index:"+rVal+","+start);
            }
                freqMap.put(rVal, end);


            maxLength  = Math.max(maxLength , end-start+1);
            System.out.println(val.charAt(start)+","+val.charAt(end));
        }
        return maxLength;
    }

    public static List<Integer> findWordConcatenation(String word, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String key: words) {
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        List<Integer> wordsIndex = new ArrayList<>();
        int wordLength = words[0].length(); int wordCount = words.length;
        for(int i=0;i<=word.length()-wordCount*wordLength;i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int j=0;j<wordCount;j++) {
                int startIndex = i+j*wordLength;
                String val = word.substring(startIndex, startIndex+wordLength);
                System.out.println("val: "+val);
                if(!map.containsKey(val)) {
                    break;
                }

                wordsSeen.put(val, wordsSeen.getOrDefault(val,0)+1);

                if(wordsSeen.get(val) > map.getOrDefault(val,0)) {
                    break;
                }

                if(j+1==wordCount) {
                    wordsIndex.add(i);
                }
            }
        }
        return wordsIndex;
    }
    public static void main(String args[]) {
        System.out.println(WordsConcatenation.findMaxLengthSubstring1("ccakbcddae"));
        List<Integer> result = WordsConcatenation.findWordConcatenation(
                "catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordsConcatenation.findWordConcatenation(
                "catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
