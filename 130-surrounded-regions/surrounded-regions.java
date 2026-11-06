class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(int row,int col,char[][] grid,int[][] vis){
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

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='O' && vis[nr][nc]!=1){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                }
            }

        }

    }
    public void solve(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int j=0;j<m;j++){
            if(grid[0][j]=='O' && vis[0][j]==0){
                vis[0][j]=1;
                bfs(0,j,grid,vis);
            }
            if(grid[n-1][j]=='O' && vis[n-1][j]==0){
                vis[n-1][j]=1;
                bfs(n-1,j,grid,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]=='O' && vis[i][0]==0){
                vis[i][0]=1;
                bfs(i,0,grid,vis);
            }
            if(grid[i][m-1]=='O' && vis[i][m-1]==0){
                vis[i][m-1]=1;
                bfs(i,m-1,grid,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O' && vis[i][j]==0){
                    grid[i][j]='X';
                }
            }
        }
    }
}