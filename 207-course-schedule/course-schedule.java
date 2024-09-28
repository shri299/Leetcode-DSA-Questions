class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[adjList.size()];
        for (int i=0;i<numCourses;i++){
            for (int node : adjList.get(i)){
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int target = queue.poll();
            ans.add(target);

            for (int neighbour: adjList.get(target)){
                inDegree[neighbour]--;
                if (inDegree[neighbour]==0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(ans.size()==numCourses){
            return true;
        }
        return false;
        
    }
}