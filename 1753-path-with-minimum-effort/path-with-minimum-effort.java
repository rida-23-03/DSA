class Solution {
    public int minimumEffortPath(int[][] h) {
        int n=h.length;
        int m=h[0].length;
        int[][] dis=new int[n][m];
        for(int[] x:dis){
            Arrays.fill(x,Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(a[0],b[0])
        );
        pq.add(new int[]{0,0,0});
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int effort=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==n-1 && c==m-1){
                return effort;
            }
            if(effort>dis[r][c]) continue;

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int diff=Math.abs(h[r][c]-h[nr][nc]);
                    int neweff=Math.max(effort,diff);
                    if(neweff<dis[nr][nc]){
                        dis[nr][nc]=neweff;
                        pq.add(new int[]{neweff,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}