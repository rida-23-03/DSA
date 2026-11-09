class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int[] indeg=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:prereq){
            adj.get(x[1]).add(x[0]);
        }
        
        for(int i=0;i<numCourses;i++){
            for(int x:adj.get(i)){
                indeg[x]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int index=0;
        
        while(!q.isEmpty()){
            int node=q.poll();
            ans[index]=node;
            index++;

            for(int x:adj.get(node)){
                indeg[x]--;
                if(indeg[x]==0){
                    q.add(x);
                }
            }
        }
        if(index!=numCourses) return new int[0];
        else return ans;
    }
}