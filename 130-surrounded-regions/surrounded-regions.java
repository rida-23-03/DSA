class Solution {
    public void dfs(int i,int j,char[][] board,int n,int m){
        if(i<0||i>=n||j<0||j>=m||board[i][j]!='O') return; 
        board[i][j]='#';
        dfs(i-1,j,board,n,m);
        dfs(i+1,j,board,n,m);
        dfs(i,j-1,board,n,m);
        dfs(i,j+1,board,n,m);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||i==n-1||j==0||j==m-1)&& board[i][j]=='O'){
                    dfs(i,j,board,n,m);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
}