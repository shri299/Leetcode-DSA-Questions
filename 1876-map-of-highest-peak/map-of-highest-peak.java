class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[] delRow = {0,-1,1,0};
        int[] delCol = {-1,0,0,1};

        boolean[][] vis = new boolean[rows][cols];
        int[][] ans = new int[rows][cols];
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isWater[i][j]==1){
                    queue.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            ans[pair.row][pair.col]= pair.distance;
            for(int i=0;i<4;i++){
                int nRow = pair.row+delRow[i];
                int nCol = pair.col+delCol[i];
                if(nRow>=0 && nCol>=0 && nRow<rows && nCol<cols && isWater[nRow][nCol]!=1 && !vis[nRow][nCol]){
                    queue.offer(new Pair(nRow,nCol,pair.distance+1));
                    vis[nRow][nCol]=true;
                }
            }
        }
        return ans;
    }

    class Pair{
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }
    }
}