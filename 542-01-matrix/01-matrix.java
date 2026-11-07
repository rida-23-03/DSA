class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    ans[i][j]=0;
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && ans[nr][nc]==-1){
                    ans[nr][nc]=ans[r][c]+1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return ans;
    }
}