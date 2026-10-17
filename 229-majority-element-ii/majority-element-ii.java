class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        int threshold=n/3;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

            if(mp.get(nums[i])>threshold && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}