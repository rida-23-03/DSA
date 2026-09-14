class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String t=sb.toString();
        int l=0;
        int r=t.length()-1;
        while(l<=r){
            if(t.charAt(l)!=t.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
