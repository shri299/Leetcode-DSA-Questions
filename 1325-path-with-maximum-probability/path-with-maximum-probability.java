class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Initialize the maximum probability array with 0.0
        // maxProb[i] represents the maximum probability of reaching node i from start_node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0; // Start node has a probability of 1.0 to reach itself

        // Iterate up to n - 1 times to ensure maximum path updates (Bellman-Ford like approach)
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false; // To check if any updates were made in this iteration

            // Traverse each edge and update the maximum probability if a better path is found
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                // Update maxProb for node v if a better path through u is found
                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    updated = true; // Mark that we made an update
                }
                
                // Update maxProb for node u if a better path through v is found
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                    updated = true; // Mark that we made an update
                }
            }

            // If no updates were made in this iteration, we can break early
            if (!updated) break;
        }

        // Return the maximum probability to reach the end_node from start_node
        return maxProb[end_node];
    }
}