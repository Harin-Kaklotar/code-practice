package trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Liju on 11/22/2016.
 */
public class Trie {
    // Root of Trie
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /* A Trie Node*/
    class TrieNode {
        private boolean isLeaf;
        private Map<Character, TrieNode> nodeMap = new TreeMap<>();

        public Map<Character, TrieNode> getNodeMap() {
            return nodeMap;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }

    /**
     * Adds given chars[] in the Trie
     * @param node - root of the Trie
     * @param chars chars to be added to the Trie
     * @param pos current position of the character to be processed
     *            initially value would be 0
     */
    public void add(TrieNode node, char[] chars, int pos) {
        if (pos < chars.length) {
            //put if absent
            if (!node.getNodeMap().containsKey(chars[pos])) {
                node.getNodeMap().put(chars[pos], new TrieNode());
            }
            // mark leaf node
            if (pos==chars.length-1){
                node.getNodeMap().get(chars[pos]).setLeaf(true);
                return;
            }
            add(node.getNodeMap().get(chars[pos]), chars, pos + 1);
        }
    }

    /**
     * Searching a key/word in the Trie
     * @param node root of the Trie
     * @param key key to be searched as char[]
     * @param pos current position of the char to be processed
     * @return true is the key is found in the Trie else false
     */
    public boolean searchKey(TrieNode node, char[] key, int pos) {
        if (node == null) {
            return false;
        }
        if (pos < key.length) {
            if (node.getNodeMap().containsKey(key[pos])) {
                if (pos == key.length - 1 && node.getNodeMap().get(key[pos]).isLeaf()) {
                    return true;
                } else {
                  return searchKey(node.getNodeMap().get(key[pos]), key, pos + 1);
                }
            }
        }
        return false;
    }


    /**
     * Deletes key from the trie
     * @param node - root of the trie
     * @param key - key to be deleted from trie
     * @param pos - current position of the char ,initially 0
     */
    public void deleteKey(TrieNode node ,char[] key,int pos){
        delete(node ,key,pos);
    }
    private boolean delete(TrieNode node ,char[] key,int pos){
        //validating input
        if (key==null || key.length==0 || pos < 0)
            return false;

        // when current position reached end
        if (pos==key.length){
            //only leaf node to me marked deleted
            if (!node.isLeaf()){
                //if not leaf node return false
                return false;
            }else {
                //if leaf node -set it as non leaf
                node.setLeaf(false);
                //return true if there is no children so that it can be removed also
                return node.getNodeMap().size()==0;
            }

        }
        final TrieNode trieNode = node.getNodeMap().get(key[pos]);
        if (trieNode==null){
            //if key is not present , nothing to delete
            return false;
        }else {
            final boolean shouldDelete = delete(trieNode, key, pos+1);
            if (shouldDelete){
                trieNode.getNodeMap().remove(key[pos]);
                return trieNode.getNodeMap().size()==0;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] input = new String[]{"sad","sam","sort","same","a","the","they","there","at"};
        for (int i = 0; i < input.length; i++) {
            // add elements to trie
            trie.add(trie.root, input[i].toCharArray(), 0);
        }

        // search elements
        System.out.println(trie.searchKey(trie.root, "sad".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "sam".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "sort".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "same".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "add".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "a".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "the".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "they".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "there".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "at".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "att".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "sade".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "sat".toCharArray(), 0));

        System.out.println("************* after delete ***************");
        trie.deleteKey(trie.root, "sad".toCharArray(), 0);
        System.out.println(trie.searchKey(trie.root, "sad".toCharArray(), 0));
        trie.deleteKey(trie.root, "sort".toCharArray(), 0);
        System.out.println(trie.searchKey(trie.root, "sort".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "they".toCharArray(), 0));
        System.out.println(trie.searchKey(trie.root, "same".toCharArray(), 0));

    }
}





