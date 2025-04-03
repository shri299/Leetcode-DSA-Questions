class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] distance = new int[rowLength][colLength];
        int[] delRow = { -1, 1, 0, 0, 1, -1, 1, -1 };
        int[] delCol = { 0, 0, -1, 1, 1, -1, -1, 1 };
        for (int i = 0; i < rowLength; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        distance[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < 8; i++) {
                if (isValid(pair.row, pair.col, delRow[i], delCol[i], grid, rowLength, colLength)) {
                    int newRow = delRow[i] + pair.row;
                    int newCol = delCol[i] + pair.col;
                    if (distance[newRow][newCol] > pair.distance + 1) {
                        distance[newRow][newCol] = pair.distance + 1;
                        pq.offer(new Pair(distance[newRow][newCol], newRow, newCol));
                    }
                }
            }
        }

        if (grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) {
            return -1;
        }

        return distance[rowLength - 1][colLength - 1] == Integer.MAX_VALUE
                ? -1
                : distance[rowLength - 1][colLength - 1] + 1; // +1 because we count steps starting from (0,0)

    }

    private boolean isValid(int nr, int nc, int dr, int dc, int[][] grid, int m, int n) {
        return nr + dr >= 0 && nc + dc >= 0 && nr + dr < m && nc + dc < n && grid[nr + dr][nc + dc] == 0;
    }

    class Pair {
        int distance;
        int row;
        int col;

        Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
}