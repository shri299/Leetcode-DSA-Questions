class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length; //number of rows
        int m = mat[0].length; //number of cols

        //create s dummy vis arr
        boolean[][] vis = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        //define the initial state of the queue
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (mat[i][j]==0){
                    queue.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }

        traversal(mat,queue,vis,distance);
        return distance;
    }

    public void traversal(int[][] input, Queue<Pair> queue, boolean[][] vis, int[][] distance) {
        int n = input.length; //number of rows
        int m = input[0].length; //number of cols

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            //set the distance for this pair
            distance[pair.row][pair.col]= pair.distance;

            //check in all the four directions
            if (isValidDirection(input,vis,n,m,pair.row+1,pair.col)){
                queue.offer(new Pair(pair.row+1,pair.col,pair.distance+1));
                vis[pair.row+1][pair.col]=true;
            }

            if (isValidDirection(input,vis,n,m,pair.row,pair.col+1)){
                queue.offer(new Pair(pair.row,pair.col+1,pair.distance+1));
                vis[pair.row][pair.col+1]=true;
            }

            if (isValidDirection(input,vis,n,m,pair.row,pair.col-1)){
                queue.offer(new Pair(pair.row,pair.col-1,pair.distance+1));
                vis[pair.row][pair.col-1]=true;
            }

            if (isValidDirection(input,vis,n,m,pair.row-1,pair.col)){
                queue.offer(new Pair(pair.row-1,pair.col,pair.distance+1));
                vis[pair.row-1][pair.col]=true;
            }
        }
    }

     public boolean isValidDirection(int[][] input, boolean[][] vis, int n, int m, int r, int c) {
        return r>=0 && r<n && c>=0 && c<m && input[r][c]!=0 && !vis[r][c];
    }

    class Pair {
        int row;
        int col;
        int distance;

        Pair (int r, int c, int d){
            this.row=r;
            this.col=c;
            this.distance=d;
        }
    }
}