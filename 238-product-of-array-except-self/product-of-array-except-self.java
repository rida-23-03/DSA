class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=1;
        int mul=1;
        for(int i=1;i<n;i++){
            mul=mul*nums[i-1];
            prefix[i]=mul;
        }
        suffix[n-1]=1;
        int mul1=1;
        for(int i=n-2;i>=0;i--){
            mul1=mul1*nums[i+1];
            suffix[i]=mul1;
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}