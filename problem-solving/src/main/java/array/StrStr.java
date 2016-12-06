package array;

/**
 * Created by liju on 12/5/16.
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 https://leetcode.com/problems/implement-strstr/

 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j==needle.length()) return i;
                if (i+j>= haystack.length()) return -1;
                if (needle.charAt(j)!=haystack.charAt(i+j)) break;
            }
        }
    }
}
