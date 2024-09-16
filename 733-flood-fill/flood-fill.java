class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //create a dummy visited array
        int n = image.length;
        int m = image[0].length;

        boolean[][] vis = new boolean[n][m];

        return bfs(sr,sc,vis,image,color);

    }

    public int[][] bfs(int sr,int sc, boolean[][] vis, int[][] image, int color){
        Queue<Pair> queue = new LinkedList<>();
        vis[sr][sc] = true;
        int target = image[sr][sc];
        image[sr][sc] = color;
        queue.offer(new Pair(sr,sc));

        while(!queue.isEmpty()){
            //go in 4 directions, hence 4 cases
            Pair p = queue.poll();
            int row = p.first;
            int col = p.second;

            if(validate(row,col-1,vis,image,target)){
                queue.offer(new Pair(row,col-1));
                vis[row][col-1]=true;
                image[row][col-1]=color;
            }

            if(validate(row,col+1,vis,image,target)){
                queue.offer(new Pair(row,col+1));
                vis[row][col+1]=true;
                image[row][col+1]=color;
            }

            if(validate(row-1,col,vis,image,target)){
                queue.offer(new Pair(row-1,col));
                vis[row-1][col]=true;
                image[row-1][col]=color;
            }

            if(validate(row+1,col,vis,image,target)){
                queue.offer(new Pair(row+1,col));
                vis[row+1][col]=true;
                image[row+1][col]=color;
            }

        }

        return image;

    }

    public boolean validate(int row, int col, boolean[][] vis, int[][] image, int target){
        int n = image.length;
        int m = image[0].length;
        return row>=0 && row<n && col>=0 && col<m && !vis[row][col] && image[row][col]==target;
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