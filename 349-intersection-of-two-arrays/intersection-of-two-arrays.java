class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans =new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                if(ans.isEmpty() ||ans.get(ans.size()-1)!=nums1[i]){
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] a1=new int[ans.size()];
        int index=0;
        for(int x:ans){
            a1[index]=x;
            index++;
        }
        return a1;
    }
}