class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        Integer[] arr=mp.keySet().toArray(new Integer[0]);
        Arrays.sort(arr,(a,b)->mp.get(b)-mp.get(a));
        int ans=arr[0];
        return ans;
    }
}