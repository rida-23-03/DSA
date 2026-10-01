class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> temp=new ArrayList<>();
        int left=0;
        int right=0;
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                temp.add(nums1[left]);
                left++;
            }
            else{
                temp.add(nums2[right]);
                right++;
            }
        }
        while(left<m) temp.add(nums1[left++]);
        while(right<n) temp.add(nums2[right++]);

        int index=0;
        for(int x:temp){
            nums1[index++]=x;
        }
    }
}