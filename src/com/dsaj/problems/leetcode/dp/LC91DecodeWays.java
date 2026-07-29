package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

// 1 2
// 3

// 1 2 3
// 1, 2, 3, 12 3, 1 23
// 5

// 1 2 3 4
// 1, 2, 3, 4, 12 3 4, 12 3 4, 1 23 4



class LC91DecodeWaysSolution {
    int valid = 0;

    private void numDecodingsHelper(char[] s, int start) {
        if(start > s.length) {
            return;
        }

        if(start == s.length) {
            valid++;
            return;
        }

        int ch = s[start] - '0';
        if (1 <= ch && ch <= 26) {
            numDecodingsHelper(s, start+1);
        }

        if(start+1 <= s.length-1 && ch != 0) {
            int ind = Integer.valueOf(ch*10 + (s[start+1] - '0'));
            if(1<= ind && ind <= 26) {
                numDecodingsHelper(s, start+2);
            }
        }
    }

    public int numDecodings(String s) {
        numDecodingsHelper(s.toCharArray(), 0);
        return valid;
    }
}

class LC91DecodeWaysMemoizationSolution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigits = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i));

            if(oneDigits >= 1) {
                dp[i] += dp[i-1];
            }

            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[dp.length - 1];
    }
}

public class LC91DecodeWays {
    public static void main(String[] args) {
        String s = SystemUtils.takeStringInput("Enter the string: ");
        System.out.println("number of ways to decode = " + new LC91DecodeWaysSolution().numDecodings(s));
        // System.out.println("abcd".substring(2, 4));
    }
}
