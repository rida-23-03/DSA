class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    
    }
    public int mergeSort(int[] nums,int low,int high){
        if(low>=high) return 0;
        int mid=low+(high-low)/2;
        int count=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=merge(nums,low,mid,high);

        return count;
    }
    public int merge(int[] nums,int low,int mid,int high){
        int j=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(j<=high && nums[i]>2L*nums[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        int left=low;
        int right=mid+1;
        List<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }
        while(left<=mid)  temp.add(nums[left++]);;
        while(right<=high) temp.add(nums[right++]);

        for(int i=0;i<temp.size();i++){
            nums[low+i]=temp.get(i);
        }
        return count;
    }
}