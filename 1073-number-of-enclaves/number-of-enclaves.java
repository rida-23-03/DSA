class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(int row,int col,int[][] grid,int[][] vis){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;

            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]!=1){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                }
            }

        }

    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||i==n-1||j==0||j==m-1)&& grid[i][j]==1 && vis[i][j]!=1){
                    vis[i][j]=1;
                    bfs(i,j,grid,vis);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}