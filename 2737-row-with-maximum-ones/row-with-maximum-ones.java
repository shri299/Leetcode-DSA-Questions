class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ansRow = 0;
        int ansCount = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
            }

            if (count > ansCount) {
                ansCount = count;
                ansRow = i;
            }
        }

        return new int[]{ansRow, ansCount};
    }
}