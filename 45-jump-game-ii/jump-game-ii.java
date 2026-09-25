class Solution {
    public int jump(int[] nums) {
        int maxr=0;
        int end=0;
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            maxr=Math.max(maxr,i+nums[i]);
            if(i==end){
                cnt++;
                end=maxr;
            }
        }
        return cnt;
    }
}