class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int low=0,high=n-1; //first and last element
        int lmax=0,rmax=0;
        int water=0;
        while(low<=high){ //until both r not same
            if(h[low]<=h[high]){ //if low is less pprocess that in this case 4<5 so 
                lmax=Math.max(lmax,h[low]);//find leftmax with currennt ele
                int curr=h[low]; //curr eemnt 
                water+=(lmax-curr);//hhere lmax=4 and curr=4 so 4-4 0 so water=0
                low++; //move to next lefft elem
            }
            else{
                rmax=Math.max(rmax,h[high]);//else f right is lower find rmax
                int curr=h[high];
                water+=(rmax-curr); //calculate water
                high--; //decrement 
            }
        }
        return water;
     }
} //tc:  o(n)+o(n)+o(n)=o(3n)approx o(n) 