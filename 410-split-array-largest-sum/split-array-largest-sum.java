class Solution {
    public static int f(int mid,int[] a){
        int sum=0;
        int cnt=1;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            //ans=Math.max(ans,sum);
            if(sum>mid){
                cnt++;
                sum=a[i];
            }
        }
        return cnt;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int l=0;
        for(int i=0;i<n;i++){
            l=Math.max(l,nums[i]); //coz max sum can never be smaller than max ele so min is atleast the max elem like 1 4 4 the maxsum is !<4 so
        }
        int h=sum;
        while(l<=h){
            int mid=l+(h-l)/2;
            int split=f(mid,nums);
            if(split>k) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
}