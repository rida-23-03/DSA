class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        int l=0;
        int cnt=0;
        for(int x:mp.values()){
            if(x%2==0){
                l=l+x;
            }
            else if(x%2!=0){
                l=l+x-1;
                cnt++;
            }
        }
        if(cnt>0) return l+1;
        else return l;
    }
}