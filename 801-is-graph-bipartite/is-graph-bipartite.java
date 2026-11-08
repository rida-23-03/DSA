class Solution {
    public boolean bfs(int i,int[][] graph,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int x:graph[node]){
                if(color[x]==-1){
                    color[x]=1-color[node];
                    q.add(x);
                }
                else if(color[x]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
}