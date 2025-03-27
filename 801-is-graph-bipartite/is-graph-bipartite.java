class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        int[] color = new int[graph.length];
        boolean isBipartite = true;
        Queue<Integer> queue = new LinkedList<>();
        color[0] = 1;

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && isBipartite) {
                vis[i] = true;
                queue.offer(i);
                while (!queue.isEmpty() && isBipartite) {
                    int parentNode = queue.poll();
                    int parentColor = color[parentNode];
                    for (int childNode : graph[parentNode]) {
                        if (!vis[childNode]) {
                            int childColor = parentColor == 0 ? 1 : 0;
                            color[childNode] = childColor;
                            vis[childNode] = true;
                            queue.offer(childNode);
                        } else {
                            if (parentColor == color[childNode]) {
                                vis[i]=true;
                                isBipartite = false;
                            }
                        }
                    }
                }
            }
        }

        return isBipartite;
    }
}