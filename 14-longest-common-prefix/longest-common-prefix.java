class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        Arrays.sort(strs);
        String s=strs[0];
        String t=strs[strs.length-1];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(i)){
                sb.append(s.charAt(i));
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}