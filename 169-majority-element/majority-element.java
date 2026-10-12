class Solution {
    public int majorityElement(int[] nums) {
        int threshold=nums.length/2;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            mp.put(curr,mp.getOrDefault(curr,0)+1);

            if(mp.get(curr)>threshold){
                return curr;
            }
        }
        return -1;
        
    }
}