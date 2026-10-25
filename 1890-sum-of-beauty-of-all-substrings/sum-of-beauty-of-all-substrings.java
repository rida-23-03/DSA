class Solution {
    public int beautySum(String s) {
       
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int maxval=Integer.MIN_VALUE;
                int minval=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]>maxval){
                        maxval=freq[k];
                    }
                    if(freq[k]<minval && freq[k]>0){
                        minval=freq[k];
                    }
                }
                int count=maxval-minval;
                ans=ans+count;
            }
        }
        return ans;
    }
}