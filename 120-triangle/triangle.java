class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return helper(0,0,triangle,dp);
    }

    private int helper(int row, int col, List<List<Integer>> triangle,int[][] dp){
        if(row==triangle.size()-1) return triangle.get(row).get(col);

        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + helper(row+1,col,triangle,dp);
        int diagonal = triangle.get(row).get(col) + helper(row+1,col+1,triangle,dp);

        return dp[row][col]=Math.min(down,diagonal);
    }
}