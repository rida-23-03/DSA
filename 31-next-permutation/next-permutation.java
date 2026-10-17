class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i;
        //finding 1st break point where curr ele is < next ele 
        for(i=n-2;i>=0;i--){ //start from right to  left  leave one elemnt to check 
            if(nums[i]<nums[i+1]){
                break;  //that index is breakpoint
            }
        }

        //find the first elemnt greater than i after the breakpoint
        if(i>=0){
            int j;
            for(j=n-1;j>=0;j--){ //traverse from last 
                if(nums[j]>nums[i]){
                    break;
                }
            }
            //swap the elents the breakpont(i) and next elem greater(j)
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        //reverse after the breakpoint
        int l=i+1;
        int r=n-1;
        while(l<=r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;

            l++;
            r--;
        }
    }
}