package com.dsaj.problems.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC3LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> visited = new HashMap<>();
        int maxLen = 0, currLen = 0;
        int slow = 0, fast = 0;

        while (fast < chars.length) {
            char ch = chars[fast];
            
            // redjust slow pointer
            if(slow <= visited.getOrDefault(ch, -1) && visited.getOrDefault(ch, -1) <= fast) {
                slow = visited.get(ch)+1;
            }

            // take new lengths
            currLen = fast-slow+1;
            maxLen = Math.max(maxLen, currLen);

            visited.put(ch, fast);
            fast++;
        }

        return maxLen;
    }
}

public class LC3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LC3LongestSubstringWithoutRepeatingCharactersSolution solution = new LC3LongestSubstringWithoutRepeatingCharactersSolution();

        String s = SystemUtils.takeStringInput("Enter the string: ");
        System.out.println("length of lingest substring: " + solution.lengthOfLongestSubstring(s));
    }
}
