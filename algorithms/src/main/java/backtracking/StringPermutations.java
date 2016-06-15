package backtracking;

/**
 * Created by liju on 6/15/16.
 *
 * permutations of string  - having non repeating chars
 *
 * no of permutations  = !n
 */
public class StringPermutations {

    public void permute(char[] chars, int l, int r) {

        if (l == r) {
            System.out.println(chars);
        } else {
            for (int i = l; i <= r; i++) {
                swap(chars, l, i);
                permute(chars, l + 1, r);
                swap(chars, l, i);// backtrack
            }
        }

    }

    public void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    public static void main(String[] args) {
        String str = "ABC";
        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.permute(str.toCharArray(), 0, str.length() - 1);
    }
}
