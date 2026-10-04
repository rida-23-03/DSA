class Solution {
    public int lengthOfLastWord(String s) {
        String[] ans=s.split(" ");
        int n=ans.length;
        int len=ans[n-1].length();
        return len;
    }
}