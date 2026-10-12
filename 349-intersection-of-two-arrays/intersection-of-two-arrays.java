class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set=new HashSet<>();
         HashSet<Integer> temp=new HashSet<>();
        
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                temp.add(nums2[i]);
            }
        }
        int[] ans=new int[temp.size()];
        int index=0;
        for(int x:temp){
            ans[index]=x;
            index++;
        }
        return ans;
    }
}