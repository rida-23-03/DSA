class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] outdeg=new int[n];
        List<List<Integer>> rev=new ArrayList<>();
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int x:graph[i]){
                outdeg[i]++;
                rev.get(x).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);

            for(int x:rev.get(node)){
                outdeg[x]--;
                if(outdeg[x]==0){
                    q.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}