class iPair {
    int i, j, diff;

    iPair(int i, int j, int diff) {
        this.i = i;
        this.j = j;
        this.diff = diff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int[][] diff = new int[rows][cols];
        for(int[] row : diff){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<iPair> q = new PriorityQueue<>((a,b) -> a.diff - b.diff);

        q.add(new iPair(0, 0, 0));
        diff[0][0] = 0;

        while(!q.isEmpty()){
            iPair p = q.poll();
            int currI = p.i;
            int currJ = p.j;
            int currDiff = p.diff;

            if (currI == rows-1 && currJ == cols-1) {
                return currDiff; //bcz of priotiy queue it will be minimum effort
            }

            for(int i=0; i<4; i++){
                int nbrR = currI + dr[i];
                int nbrC = currJ + dc[i];

                if(nbrR >= 0 && nbrR < rows && nbrC >= 0 && nbrC < cols){
                    int nbrEffort = Math.max(currDiff, Math.abs(grid[nbrR][nbrC] - grid[currI][currJ]));

                    if(nbrEffort < diff[nbrR][nbrC]){
                        diff[nbrR][nbrC] = nbrEffort;
                        q.add(new iPair(nbrR, nbrC, nbrEffort));
                    }
                }
            }
        }

        return 0;
    }
}