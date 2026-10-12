class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            int curr=nums1[i];
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(mp.containsKey(nums2[i])){
                l.add(nums2[i]);
                mp.put(nums2[i],mp.get(nums2[i])-1);
                if(mp.get(nums2[i])==0){
                    mp.remove(nums2[i]);
                }
            }
        }
        int[] ans=new int[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}