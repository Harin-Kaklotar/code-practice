package array;

/**
 * Created by liju on 12/5/16.
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        int[] charsCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charsCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] != 0)
                return false;
        }
        return true;
    }
}
