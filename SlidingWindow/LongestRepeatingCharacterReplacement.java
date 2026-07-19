package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
     public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 1;

        int maxFreq = 1;
        for(int right = 0; right < s.length(); right++) {
            // add element to map
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, val + 1);
                maxFreq = Math.max(maxFreq, val + 1);
            } else {
                map.put(c, 1);
                maxFreq = Math.max(maxFreq, 1);
            }

            if((right - left + 1 - maxFreq) > k) {
                // remove 1 element from left and recalculate max element
                maxFreq = 1;
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
                // calculate new maxFreq
                for(int val: map.values()) {
                    maxFreq = Math.max(maxFreq, val);
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);

        }
             
        return maxLen;
        
    }
}
