class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int startingRow = 0;
        int endingRow = m - 1;
        int startingColumn = 0;
        int endingColumn = n - 1;

        while (startingRow <= endingRow &&
                startingColumn <= endingColumn) {

            // Left → Right
            for (int col = startingColumn; col <= endingColumn; col++) {
                res.add(matrix[startingRow][col]);
            }
            startingRow++;

            // Top → Bottom
            for (int row = startingRow; row <= endingRow; row++) {
                res.add(matrix[row][endingColumn]);
            }
            endingColumn--;

            // Right → Left
            if (startingRow <= endingRow) {
                for (int col = endingColumn; col >= startingColumn; col--) {
                    res.add(matrix[endingRow][col]);
                }
                endingRow--;
            }

            // Bottom → Top
            if (startingColumn <= endingColumn) {
                for (int row = endingRow; row >= startingRow; row--) {
                    res.add(matrix[row][startingColumn]);
                }
                startingColumn++;
            }
        }

        return res;
    }
}
