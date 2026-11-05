class Solution {
    public void bfs(int i,int[][] isConnected,int[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[node][j]==1 && vis[j]!=1){
                    vis[j]=1;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                vis[i]=1;
                count++;
                bfs(i,isConnected,vis);
            }
        }
        return count;
        
    }
}