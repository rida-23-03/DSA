class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                len=Math.max(len,cnt);
            }
            else{
                cnt=0;
            }
        }
        return len;
    }
}