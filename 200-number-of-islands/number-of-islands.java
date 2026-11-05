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
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;

            for(int i=0;i<4;i++){
                int newrow=r+delrow[i];
                int newcol=c+delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]=='1' && 
                vis[newrow][newcol]!=1){
                    vis[newrow][newcol]=1;
                    q.add(new Pair(newrow,newcol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]!=1){
                    vis[i][j]=1;
                    count++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
}