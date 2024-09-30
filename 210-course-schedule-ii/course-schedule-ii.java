class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];

        //make adjacency list

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        } 

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }   

        //make indegree

        for(int i=0;i<adjList.size();i++){
            for(int node: adjList.get(i)){
                indegree[node]++;
            }
        } 

        //intialize the queue

        for(int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        } 

        //perform bfs

        while (!queue.isEmpty()){
            int target = queue.poll();
            ans.add(target);

            for (int neighbour: adjList.get(target)){
                indegree[neighbour]--;
                if (indegree[neighbour]==0) {
                    queue.offer(neighbour);
                }
            }
        }  

        if(ans.size()!=numCourses){
            return new int[0];
        }   

        Integer[] tempArray = ans.toArray(new Integer[0]);  

        int[] intArray = new int[tempArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            intArray[i] = tempArray[i]; // Unboxing from Integer to int
        }

        return intArray;               
    }
}