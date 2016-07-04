package dp;

import java.util.*;

/**
 * Created by liju on 7/2/16.
 *
 * Given a string and a dictionary, split this string into multiple words such that each word belongs in dictionary.
 *
 * e.g peanutbutter -> pea nut butter e.g Iliketoplay -> I like to play
 *
 * Ref  - http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 *
 */
public class WordSplit {

    // simple recursive solution
    private boolean splitWords(Set<String> dic, String word, Stack<String> splitResult) {

        if (dic.contains(word)) {
            return true;
        }

        for (int splitAt = 1; splitAt < word.length(); splitAt++) {

            boolean result = splitWords(dic, word.substring(0, splitAt), splitResult) && splitWords(dic, word.substring(splitAt, word.length()), splitResult);

            if (result) {
                return result;
            }

        }

        return false;
    }

    // dp memoization solution which return true or false
    public boolean splitWordsDP(Set<String> dic, String word, int start, int end, Map<Integer, Boolean> lookup) {

        if (start == end) {
            return true;
        }

        if (lookup.get(start) == null) {
            for (int i = start; i <= end; i++) {

                if (dic.contains(word.substring(start, i)) && splitWordsDP(dic, word, i, end, lookup)) {
                    lookup.put(start, true);
                    return true;
                }
            }

            lookup.put(start, false);
        }

        return lookup.get(start);

    }

    //Solution using dp memoization - returns splitted words also
    public List<String> splitWordDP(Set<String> dic, String word, int start, int end, Map<Integer, List<String>> lookup) {

        if (start == end) {
            return Collections.singletonList("");
        }

        if (lookup.get(start) == null) {
            List<String> list = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                String newWord = word.substring(start, i);
                if (!dic.contains(newWord)) {
                    continue;
                }
                List<String> result = splitWordDP(dic, word, i, end, lookup);
                //add to current recusrions list only if result has splitable words
                if (result.size() > 0){
                    list.addAll(result);
                    list.add(newWord);
                }
            }
            lookup.put(start, list);
        }

        return lookup.get(start);
    }

    public static void main(String[] args) {
        Set<String> dic = new HashSet<>();
        dic.add("pea");
        dic.add("nut");
        dic.add("butter");
        dic.add("i");
        dic.add("like");
        dic.add("am");

        WordSplit wordSplit = new WordSplit();

        Stack<String> stack = new Stack<>();

        String word = "iilikepeanut";
        System.out.println("is word splitable using naive recursive solution : " + wordSplit.splitWords(dic, word, stack));

        System.out.println("is word splitable using dp topdown solution : " + wordSplit.splitWordsDP(dic, word, 0, word.length(), new HashMap<>()));

        List<String> list = wordSplit.splitWordDP(dic, word, 0, word.length(), new HashMap<>());

        for (String split : list) {
            System.out.println(split);
        }

    }
}
