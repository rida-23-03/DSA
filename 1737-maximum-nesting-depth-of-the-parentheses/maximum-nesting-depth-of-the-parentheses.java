class Solution {
    public int maxDepth(String s) {
        int ans=0;
        int depth=0;
        int maxdep=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                depth++;
            }
            else if(c==')'){
                maxdep=Math.max(maxdep,depth);
                depth--;
            }
        }
        return maxdep;
    }
}