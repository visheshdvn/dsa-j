// explanations added

package com.dsaj.problems.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC929Solution {

    /*
    The Verdict: Algorithmically Optimal, but Implementation is Heavy

    While the time complexity is as good as it gets, the memory overhead and object creation in your implementation can be heavily optimized.

    Here is where your current approach is doing extra work under the hood:

    str.split("@"): This scans the string to find the @, creates a new String[] array, and creates two entirely new String objects (local and domain).

    s[0].toCharArray(): This creates yet another character array in memory by copying the characters out of the local string.

    String Concatenation (sb.toString() + "@" + s[1]): Using the + operator to combine strings creates another temporary
    
    StringBuilder internally and allocates memory for the final string.
     */
    public String sanitizeString(String str) {
        String[] s = str.split("@");
        StringBuilder sb = new StringBuilder();

        char[] domainArr = s[0].toCharArray();
        for (char c : domainArr) {
            if (c == '.') {
                continue;
            } else if (c == '+') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString() + "@" + s[1];
    }


    /*
    To optimize this, we can avoid split() and toCharArray() altogether. We can iterate through the raw string
    using charAt() and append directly to a single StringBuilder. Once we hit a + or @, we can fast-forward our pointer.
     */
    public String sanitizeStringOptimized(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);

            if(c == '+' || c == '@') {
                break;
            } else if (c != '.') {
                sb.append(c);
            }
            i++;
        }

        while (str.charAt(i) != '@') {
            i++;
        }

        sb.append(str.substring(i));

        return sb.toString();
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String string : emails) {
            String sanitized = sanitizeStringOptimized(string);

            set.add(sanitized);
        }

        ArrayUtils.printArray(set.toArray());
        
        return set.size();
    }
}

public class LC929UniqueEmailAddresses {
    public static void main(String[] args) {
        LC929Solution solution = new LC929Solution();

        String[] arr = SystemUtils.takeStringArrayInput("Enter email addresses: ");
        // String[] arr = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        // String[] arr = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};

        // ArrayUtils.printArray(arr);

        int n = solution.numUniqueEmails(arr);

        System.out.println("unique email: " + n);
    }
}
