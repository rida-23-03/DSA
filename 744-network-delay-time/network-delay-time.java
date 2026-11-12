class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:times){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
        }
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(a[1],b[1])
        );
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int cost=curr[1];

            if(cost>dis[node]) continue;

            for(int[] x:adj.get(node)){
                int v=x[0];
                int wt=x[1];

                if(cost+wt<dis[v]){
                    dis[v]=cost+wt;
                    pq.add(new int[]{v,dis[v]});
                }
            }
        }

        for(int i=1;i<n+1;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
        }
        int ans=0;
        for(int i=1;i<n+1;i++){
            ans=Math.max(ans,dis[i]);
        }
        return ans;
    }
}