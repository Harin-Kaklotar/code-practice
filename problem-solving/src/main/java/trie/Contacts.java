package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 1/5/17.
 *
 * https://www.hackerrank.com/challenges/contacts We're going to make our own Contacts application! The application must
 * perform two types of operations:
 * 
 * 1. add name, where name is a string denoting a contact name. This must store as a new contact in the application.
 * 2. find partial, where partial is a string denoting a partial name to search the application for. It must count the
 * number of contacts starting with partial and print the count on a new line.
 */
public class Contacts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int queries = sc.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < queries; i++) {
            final String operationType = sc.next();

            switch (operationType) {
            case "add":
                trie.add(sc.next());
                break;
            case "find":
                final int count = trie.countPrefixSize(sc.next());
                System.out.println(count);
                break;
            default:
                throw new IllegalArgumentException("illegal operation " + operationType);
            }
        }
    }

    private static class Trie {
        class TrieNode {
            boolean isLeaf;
            int prefixSize = 1;
            Map<Character, TrieNode> map = new HashMap<>();
        }

        private final TrieNode root = new TrieNode();

        public void add(String input) {
            add(input, root, 0);
        }

        private void add(String input, TrieNode root, int pos) {
            if (!root.map.containsKey(input.charAt(pos))) {
                root.map.put(input.charAt(pos), new TrieNode());
            } else {
                root.map.get(input.charAt(pos)).prefixSize++;
            }
            if (pos == input.length() - 1) {
                root.map.get(input.charAt(pos)).isLeaf = true;
                return;
            }
            add(input, root.map.get(input.charAt(pos)), ++pos);
        }

        public int countPrefixSize(String prefix) {
            return countPrefixSize(prefix, root, 0);
        }

        private int countPrefixSize(String prefix, TrieNode root, int pos) {
            if (pos == prefix.length() - 1) {
                return (root.map.containsKey(prefix.charAt(pos))) ? root.map.get(prefix.charAt(pos)).prefixSize : 0;
            }
            if (root.map.containsKey(prefix.charAt(pos))) {
                return countPrefixSize(prefix, root.map.get(prefix.charAt(pos)), ++pos);
            } else {
                return 0;
            }
        }
    }
}
