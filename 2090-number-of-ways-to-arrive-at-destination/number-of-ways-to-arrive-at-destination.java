class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:roads){
            int u=x[0];
            int v=x[1];
            int wt=x[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        long[] dis=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(
            (a,b)-> Long.compare(a[1],b[1])
        );
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            int node=(int)curr[0];
            long cost=curr[1];

            if(cost>dis[node]) continue;
            for(int[] x:adj.get(node)){
                int v=x[0];
                int wt=x[1];

                if(wt+cost<dis[v]){
                    dis[v]=wt+cost;
                    pq.add(new long[]{v,dis[v]});
                }
            }
        }
        List<List<Integer>> dag=new ArrayList<>();
        for(int i=0;i<n;i++){
            dag.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int[] x:adj.get(i)){
                int v=x[0];
                int wt=x[1];

                if(wt+dis[i]==dis[v]){
                    dag.get(i).add(v);
                }
            }
        }

        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++){
            order[i]=i;
        }
        Arrays.sort(order,(a,b)->Long.compare(dis[a],dis[b]));

        long[] ways=new long[n];
        ways[0]=1;
        int MOD = 1_000_000_007;

        for(int u:order){
            for(int v:dag.get(u)){
                ways[v]=(ways[v]+ways[u])%MOD;
            }
        }
        return (int) ways[n-1];
    }
}