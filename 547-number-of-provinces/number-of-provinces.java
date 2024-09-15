class Solution {
    public int findCircleNum(int[][] isConnected) {
        //convert adj matrix to adj list
        ArrayList<ArrayList<Integer>> nodeList = new ArrayList<ArrayList<Integer>>();
        int len = isConnected.length;
        for(int i=0;i<=len;i++)
        {
            nodeList.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(isConnected[i][j]==1 && i!=j)
                {
                    nodeList.get(i+1).add(j+1);
                    nodeList.get(j+1).add(i+1);
                }
            }
        }

        return traversal(len,nodeList);


    }

    public static int traversal(int totalNodes, ArrayList<ArrayList<Integer>> adjList){
        int count = 0;
        boolean[] visitedArray = new boolean[totalNodes+1];
        visitedArray[0] = true; //we have nothing to do with this index
        for(int i=0;i<visitedArray.length;i++){
            if (!visitedArray[i]){
                traverse(visitedArray,adjList,i);
                count++;
            }
        }
        return count;
    }

    private static void traverse(boolean[] visitedArray, ArrayList<ArrayList<Integer>> adjList, int node) {
        visitedArray[node]=true;
        for (Integer neighbourNodes : adjList.get(node)){
            if (!visitedArray[neighbourNodes]){
                traverse(visitedArray,adjList,neighbourNodes);
            }
        }
    }
}