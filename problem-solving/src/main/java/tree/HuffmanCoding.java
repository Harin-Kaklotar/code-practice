package tree;

/**
 * Created by Liju on 12/8/2016.
 * Huffman coding assigns variable length codewords to fixed length input characters based on their frequencies. More frequent characters are assigned shorter
 * codewords and less frequent characters are assigned longer codewords. A Huffman tree is made for the input string and characters are decoded based on their
 * position in the tree. We add a '0' to the codeword when we move left in the binary tree and a '1' when we move right in the binary tree. We assign codes to
 * the leaf nodes which represent the input characters.
 */
public class HuffmanCoding {

    void decode(String S, Node root) {
        Node tmp = root;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0')
                tmp = tmp.left;
            if (S.charAt(i) == '1')
                tmp = tmp.right;
            if (isLeafNode(tmp)) {
                System.out.print(tmp.data);
                tmp = root;
            }
        }
    }

    private boolean isLeafNode(Node tmp) {
        return tmp.left == null && tmp.right == null;
    }

    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

}
