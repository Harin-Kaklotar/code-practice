package graph;

/**
 * Boggle (Find all possible words in a board of characters) Given a dictionary, a method to do lookup in dictionary and
 * a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of
 * adjacent charactersNote that we can move to any of 8 adjacent characters, but a word should not have multiple
 * instances of same cell.
 *
 * refer Boggle.png
 */
public class Boggle {
    private String[] dictionary;

    public Boggle(String[] dictionary, char[][] boggle) {
        this.dictionary = dictionary;
    }

    public boolean isWord(String str) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].equals(str))
                return true;
        }
        return false;
    }

    /**
     * Recursive / DFS function
     *
     */
    public void findWords(char[][] boggle, boolean[][] visited, int row, int column, String str) {

        visited[row][column] = true;
        str = str + boggle[row][column];

        if (isWord(str)) {
            System.out.println(str);
        }

        // traverse 8 adjacent cells to the current cell
        for (int i = row - 1; i <= row + 1 && i < boggle[row].length; i++) {
            for (int j = column - 1; j <= column + 1 && i >= 0 && j < boggle[i].length; j++) {
                if (i >= 0 && j >= 0 && !visited[i][j]) {
                    findWords(boggle, visited, i, j, str);
                }
            }
        }

        visited[row][column] = false;
    }

    public static void main(String[] args) {
        String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };
        char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

        Boggle bg = new Boggle(dictionary, boggle);

        boolean[][] visited = new boolean[boggle.length][];
        for (int i = 0; i < boggle.length; i++) {
            visited[i] = new boolean[boggle[i].length];
        }

        String str = "";
        for (int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[i].length; j++) {

                bg.findWords(boggle, visited, i, j, str);

            }
        }
    }
}