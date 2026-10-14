class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length/2;
        int[] pos=new int[n];
        int x=0;
        int[] neg=new int[n];
        int y=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[x++]=nums[i];
            }
            else{
                neg[y++]=nums[i];
            }
        }
        int[] ans=new int[nums.length];
        int z=0;
        int i=0,j=0;
        while(i<n && j<n){
            ans[z++]=pos[i];
            ans[z++]=neg[j];
            i++;
            j++;
        }
        return ans;
    
    }
}