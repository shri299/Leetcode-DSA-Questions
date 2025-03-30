class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create a adj list from the given prerequisites
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        int count = 0;

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //now use kahns algo to check if cycle exists, if it does return false else true

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[adjList.size()];

        for(int i=0;i<adjList.size();i++){
            for (int node : adjList.get(i)){
                inDegree[node]++;
            }
        }

        for(int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int val = queue.poll();
            count++;
            for(int neighbour: adjList.get(val)){
                inDegree[neighbour]--;
                if (inDegree[neighbour]==0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(count==numCourses){
            return true;
        }
        return false;
    }
}