class Solution {
    public int numIslands(char[][] grid) {
        //create a dummy visited array
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;  //placeholder for the answer

        //iterating the entire grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]!='0'){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        

        return count;
    }

    public void bfs(int r, int c, boolean[][] vis, char[][] grid){
        Queue<Pair> queue = new LinkedList<>(); //queue for bfs
        vis[r][c] = true;
        queue.offer(new Pair(r,c));

        //traverse the neigbours

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            //4 directions -> 4 cases

            if(validate(row-1,col,vis,grid)){
                queue.offer(new Pair(row-1,col));
                vis[row-1][col] = true;
            }

            if(validate(row+1,col,vis,grid)){
                queue.offer(new Pair(row+1,col));
                vis[row+1][col] = true;
            }

            if(validate(row,col+1,vis,grid)){
                queue.offer(new Pair(row,col+1));
                vis[row][col+1] = true;
            }

            if(validate(row,col-1,vis,grid)){
                queue.offer(new Pair(row,col-1));
                vis[row][col-1] = true;
            }
        }
        
    }

    public boolean validate(int row, int col, boolean[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        return row>=0 && row<n && col>=0 && col<m && !vis[row][col] && grid[row][col]!='0';
    }

    class Pair{
        int first;
        int second;

        Pair (int first, int second){
            this.first=first;
            this.second=second;
        }
    }
}