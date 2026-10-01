class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=n-1;
        int merged=m+n-1;
        while(right>=0){
            if(left>=0 && nums1[left]>nums2[right]){
                nums1[merged]=nums1[left];
                left--;
                merged--;
            }
            else{
                nums1[merged]=nums2[right];
                right--;
                merged--;
            }
        }
    }
}