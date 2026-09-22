class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] ans=new int[2];
        for(int i=nums.length-1;i>=0;i--){
            int need=target-nums[i];
            if(mp.containsKey(need)){
                ans[1]=mp.get(need);
                ans[0]=i;
                break;
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}
