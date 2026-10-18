class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int candidate1=0, count1=0;
        for(int num:nums){
            if(count1==0){
                candidate1=num;
                count1=1;
            }
            else if(num==candidate1){
                count1++;
            }
            else{
                count1--;
            }
        }

        count1=0;
        for(int num:nums){
            if(num==candidate1) count1++;
        }
        int ans=0;
        if(count1>n/2) ans=candidate1;
        return ans;
        
    }
}