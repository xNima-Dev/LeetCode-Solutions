import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current == '.') continue;

                String rowKey = "row " + i + " has " + current;
                String colKey = "col " + j + " has " + current;
                String boxKey = "box " + (i / 3) + "-" + (j / 3) + " has " + current;

                // If any of these already exist in the set, the board is invalid
                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}