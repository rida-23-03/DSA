class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int l=0,r=0;
        int maxle=1,start=0;
        for(int i=0;i<n;i++){
            l=i;
            r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>maxle){
                start=l;
                maxle=len;
                }
                
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>maxle){
                start=l;
                maxle=len;
                }
                
                l--;
                r++;
            }
        }
        return s.substring(start,start+maxle);
    }
}