class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(nums.length==0) return 0;
        int cnt=1;
        int maxc=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i]==nums[i+1]-1){
                cnt++;
            }
            else{
                cnt=1;
            }
            maxc=Math.max(cnt,maxc);
        }
        return maxc;
    }
}