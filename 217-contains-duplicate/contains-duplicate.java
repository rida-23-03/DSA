class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mp=new HashSet<>();
        for(int x:nums){
            if(mp.contains(x)){
                return true;
            }
            mp.add(x);
        }
        return false;
    }
}