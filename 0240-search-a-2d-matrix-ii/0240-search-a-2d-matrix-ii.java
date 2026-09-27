class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Top-Right Corner එකෙන් ආරම්භ කිරීම
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int currentValue = matrix[row][col];

            if (currentValue == target) {
                return true;
            } else if (currentValue > target) {
                col--; // Target එක කුඩා නම් වමට ගමන් කරන්න
            } else {
                row++; // Target එක විශාල නම් පහළට ගමන් කරන්න
            }
        }

        return false;
    }
}