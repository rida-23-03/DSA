class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxc=0;

        for(int num:set){
            if(!set.contains(num-1)){
                int curr=num;
                int cnt=1;

                while(set.contains(curr+1)){
                    curr++;
                    cnt++;
                }
                maxc=Math.max(maxc,cnt);
            }
        }
        return maxc;
    }
}