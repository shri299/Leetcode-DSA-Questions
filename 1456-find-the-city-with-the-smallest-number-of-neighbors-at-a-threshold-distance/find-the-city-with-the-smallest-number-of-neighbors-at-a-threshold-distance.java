class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
            cost[i][i]=0;
        }
        for(int i=0;i<edges.length;i++){
            cost[edges[i][0]][edges[i][1]]=edges[i][2];
            cost[edges[i][1]][edges[i][0]]=edges[i][2];
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(cost[i][via]!=Integer.MAX_VALUE && cost[via][j]!=Integer.MAX_VALUE)
                    {
                        cost[i][j] = Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                    }
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for(int city = 0; city < n; city++) {
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++) {
                if(cost[city][adjCity] <= distanceThreshold)
                    cnt++;
            }
            if(cnt<=cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }

        return cityNo;
    }
}