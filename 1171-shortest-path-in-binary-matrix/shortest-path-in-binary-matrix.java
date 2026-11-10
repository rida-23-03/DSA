class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int bfs(int row,int col,int[][] grid,int[][] vis,int n,int m){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1,  0,  1,-1, 1,-1, 0, 1};
        int len=1;

        while(!q.isEmpty()){
            int s=q.size();
            for(int k=0;k<s;k++){
                Pair p=q.poll();
                int r=p.row;
                int c=p.col;
                if(r==n-1 && c==m-1){
                    return len;
                }
                for(int i=0;i<8;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0 && vis[nr][nc]==0){
                        vis[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            len++;
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        vis[0][0]=1;

        if(grid[0][0]==1||grid[n-1][m-1]==1){
            return -1;
        }
        
        return bfs(0,0,grid,vis,n,m);
    }
}