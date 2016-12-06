package array;

/**
 * Created by liju on 12/5/16.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubString {

    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("abbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s.length()==1 ||s.length()==0) return s.length();
        int len=0;
        int max=0;

        for (int k = 0; k < s.length(); k++) {
            for (int l = k+1; l < s.length(); l++) {
                if (s.charAt(k)!=s.charAt(l)){
                    len++;
                }else{
                    if (len>max) {
                        max = len;
                    }
                    len=0;
                    break;
                }
            }
        }

        return max;
    }
}
