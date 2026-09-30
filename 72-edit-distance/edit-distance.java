class Solution {
    public int f(int i,int j,String s,String t,int[][] dp){
        if(i==s.length()) return t.length()-j;
        if(j==t.length()) return s.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return 0+f(i+1,j+1,s,t,dp);
        }
        else{
            int rep=1+f(i+1,j+1,s,t,dp);
            int ins=1+f(i,j+1,s,t,dp);
            int del=1+f(i+1,j,s,t,dp);

            dp[i][j]=Math.min(rep,Math.min(ins,del));
        }
        return dp[i][j];
    }
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        int ans=f(0,0,s,t,dp);
        return ans;
    }
}