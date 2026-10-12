class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int as=0,is=0;
        for(int i=0;i<n;i++){
            as+=nums[i];
        }
        for(int i=1;i<=n;i++){
            is+=i;
        }
        int miss=is-as;
        return miss;
    }
}