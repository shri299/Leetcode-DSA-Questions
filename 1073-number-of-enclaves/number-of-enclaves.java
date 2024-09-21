class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1){ //check for boundry O's
                    queue.offer(new Pair(i,j));
                    vis[i][j]=true;
                }else if(grid[i][j]==0){
                    vis[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty()){
            int row1 = queue.peek().row;
            int col1 = queue.peek().col;
            queue.remove();

            for(int i=0;i<4;i++){
            int newRow = row1 + delRow[i];
            int newCol = col1 + delCol[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !vis[newRow][newCol] && grid[newRow][newCol]!=0){
               queue.offer(new Pair(newRow,newCol));
               vis[newRow][newCol]=true;
            }
        }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    class Pair {
        int row;
        int col;

        Pair (int r, int c){
            this.row=r;
            this.col=c;
        }
    }
}