package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while(map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
        
    }
}
