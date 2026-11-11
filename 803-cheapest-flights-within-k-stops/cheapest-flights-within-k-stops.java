class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:flights){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
        }
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,src,0});

        while(!q.isEmpty()){
            int s=q.size();
            int[] temp=dis.clone();
            for(int j=0;j<s;j++){
                int[] curr=q.poll();
                int stop=curr[0];
                int place=curr[1];
                int cost=curr[2];

                if(stop==k+1) continue;

                for(int[] x:adj.get(place)){
                    int v=x[0];
                    int wt=x[1];
                    int newstop=stop+1;
                    int newcost=cost+wt;
                    if(newcost<temp[v]){
                        temp[v]=newcost;
                        q.add(new int[]{newstop,v,newcost});
                    }
                }
            }
            dis=temp;
        }
        if(dis[dst]==Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}