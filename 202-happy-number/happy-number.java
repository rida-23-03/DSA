class Solution {
    public boolean isHappy(int n) {
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        while(n!=0){
            int d=n%10;
            sum+=d*d;
            n=n/10;
        }
        while(sum>1){
            n=sum;
            if(set.contains(n)) return false;
            set.add(n);
            sum=0;
            while(n!=0){
                int d=n%10;
                sum+=d*d;
                n=n/10;
            }
        }
        return true;
    }
}