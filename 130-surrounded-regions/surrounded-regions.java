class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O'){ //check for boundry O's
                    dfs(i,j,vis,board,delRow,delCol);
                }else if(board[i][j]=='X'){
                    vis[i][j]=true;
                }
            }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }

    public void dfs(int row, int col, boolean[][] vis, char[][] board, int[] delRow, int[] delCol){
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;

        //check in four directions

        for(int i=0;i<4;i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !vis[newRow][newCol] && board[newRow][newCol]!='X'){
                dfs(newRow,newCol,vis,board,delRow,delCol);
            }
        }
    }
}