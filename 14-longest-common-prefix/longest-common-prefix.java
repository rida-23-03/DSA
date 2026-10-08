class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        Arrays.sort(strs);
        String s=strs[0];
        String t=strs[strs.length-1];
        //StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length() && i<t.length()){
            if(s.charAt(i)==t.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        return s.substring(0,i);
    }
}