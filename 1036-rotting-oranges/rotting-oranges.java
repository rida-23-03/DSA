class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        int minutes=0;
        Queue<Pair> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            boolean rotten=false;
            for(int k=0;k<size;k++){
                Pair p=q.poll();
                int r=p.row;
                int c=p.col;

                for(int i=0;i<4;i++){
                    int nr=r+delrow[i];
                    int nc=c+delcol[i];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new Pair(nr,nc));
                        rotten=true;
                    }
                }
            }
            if(rotten){
                minutes++;
            }

        }
        if(fresh==0) return minutes;
        else return -1;
    }
}