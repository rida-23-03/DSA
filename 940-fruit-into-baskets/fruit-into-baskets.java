class Solution {
    public int totalFruit(int[] n) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int l=0,r=0,ans=0;
        for(r=0;r<n.length;r++){
            int curr=n[r];
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            while(mp.size()>2){
                mp.put(n[l],mp.get(n[l])-1);
                if(mp.get(n[l])==0){
                    mp.remove(n[l]);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}