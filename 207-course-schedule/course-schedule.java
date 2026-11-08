class Solution {
    public boolean dfs(int i,List<List<Integer>> adj,int[] vis,int[] path){
        vis[i]=1;
        path[i]=1;
        for(int x:adj.get(i)){
            if(vis[x]!=1){
                if(dfs(x,adj,vis,path)){
                    return true;
                }
            }
            else if(path[x]==1){
                return true;
            }
        }
        path[i]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:prereq){
            adj.get(x[1]).add(x[0]);
        }

        int[] vis=new int[numCourses];
        int[] path=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,vis,path)){
                    return false;
                }
            }
        }
        return true;
    }
}