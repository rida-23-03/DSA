class Solution {
    public int maxProduct(int[] nums) {
        int maxend=nums[0];
        int minend=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int x=nums[i];
            if(x<0){
                int temp=maxend;
                maxend=minend;
                minend=temp;
            }
            maxend=Math.max(x,maxend*x);
            minend=Math.min(x,minend*x);
            ans=Math.max(ans,maxend);
        }
        return ans;
    }
}