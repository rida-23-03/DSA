class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] f=new int[26];
        for(int i=0;i<s1.length();i++){
            f[s1.charAt(i)-'a']++;
            f[s2.charAt(i)-'a']--;
        }
        if(isZero(f)) return true;
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            f[s2.charAt(l)-'a']++;
            l++;
            f[s2.charAt(r)-'a']--;

            if(isZero(f)) return true;
        }
        return false;
    }
    private boolean isZero(int[] f){
        for(int x:f){
            if(x!=0) return false;
        }
        return true;
    }

}