package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 1/5/17. https://www.hackerrank.com/challenges/no-prefix-set
 */
public class NoPrefixSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int noOfWords = sc.nextInt();
        Trie trie = new Trie();
        boolean result = true;
        String GOOD_SET = "GOOD SET";
        String BAD_SET = "BAD SET";
        String firstBadString = "";
        for (int i = 0; i < noOfWords; i++) {
            if (result) {
                String tmp = sc.next();
                result = trie.add(tmp);
                if (!result)
                    firstBadString = tmp;
            } else {
                // do nothing
                sc.next();
            }
        }
        System.out.println(result ? GOOD_SET : BAD_SET);
        if (!result)
            System.out.println(firstBadString);

    }

    private static class Trie {
        class TrieNode {
            boolean isLeaf;
            Map<Character, TrieNode> map = new HashMap<>();
        }

        private final TrieNode root = new TrieNode();

        public boolean add(String input) {
            return add(input, root, 0);
        }

        private boolean add(String input, TrieNode root, int pos) {
            if (!root.map.containsKey(input.charAt(pos))) {
                root.map.put(input.charAt(pos), new TrieNode());
            } else {
                if (root.map.get(input.charAt(pos)).isLeaf)
                    return false;
            }
            if (pos == input.length() - 1) {
                root.map.get(input.charAt(pos)).isLeaf = true;
                return true;
            }
            return add(input, root.map.get(input.charAt(pos)), ++pos);
        }
    }
}
