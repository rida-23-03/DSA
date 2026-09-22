class Solution {
    public int[] twoSum(int[] n, int t) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] ans=new int[2];
        for(int i=n.length-1;i>=0;i--){
            int c=n[i];
            int need=t-c;
            if(mp.containsKey(need)){
                ans[0]=i+1;
                ans[1]=mp.get(need)+1;
                break;
            }
            mp.put(c,i);
        }
        return ans;
    }
}
