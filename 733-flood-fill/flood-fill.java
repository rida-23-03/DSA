class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public void bfs(int sr,int sc,int[][] image,int color,int oldcolor){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        int n=image.length;
        int m=image[0].length;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;

            for(int i=0;i<4;i++){
                int newrow=r+delrow[i];
                int newcol=c+delcol[i];

                if(newrow>=0 && newrow<n &&newcol>=0 && newcol<m && image[newrow][newcol]==oldcolor){
                    image[newrow][newcol]=color;
                    q.add(new Pair(newrow,newcol));
                }
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        image[sr][sc]=color;
        if(oldcolor==color){
            return image;
        }
        bfs(sr,sc,image,color,oldcolor);
        return image;
    }
}