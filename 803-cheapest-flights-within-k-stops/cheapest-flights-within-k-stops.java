class Solution {
    // modified Dijkstra.
    public int findCheapestPrice(int n, int[][] flights, 
                                 int src, int dst, int k) {
        // Build graph.
        // node i -> list of (node j, cost)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        
        // Queue node is int[] -> loc, cost, stops;
        PriorityQueue<int[]> pq = new PriorityQueue<>(10,
                        (o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{src, 0, 0});
        
        // Min cost tracker.
        // min cost for k stop arriving at n node.
        int[][] minCost = new int[k + 2][n];
        int inf = 1000000;
        for (int i = 0; i <= k + 1; i++) {
            for (int j = 0; j < n; j++) {
                minCost[i][j] = inf;
            }
        } 
        
        minCost[0][src] = 0;
        
        // Best first search.
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int curNode = cur[0];
            int curCost = cur[1];
            int curStops = cur[2];
            
            if (curNode == dst) return curCost;
            
            // No more stops possible, don't expand.
            if (curStops == k + 1) continue;
            
            // outdated values.
            if (curCost > minCost[curStops][cur[0]]) continue;
            
            // Expand cur best path. 
            for (int[] e : graph.get(curNode)) {
                if (curCost + e[1] < minCost[curStops + 1][e[0]]) {
                    // cur -> e[0];
                    minCost[curStops + 1][e[0]] = curCost + e[1];
                    pq.offer(new int[]{e[0], 
                                       minCost[curStops + 1][e[0]], 
                                       curStops + 1});
                }
            }
        }
        
        return -1;
    }
}