class Solution {
    public int lengthOfLastWord(String s) {
        int len=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                len++;
            }
            else{
                if(len>0){//why? becoz " the moon " na last itself is ' ' so comes to else returns 0 but we need to ignore last space and check the len so here len!>0 so i++ go to n of moon then count it giving 4 as output.
                    return len;
                }
            }
        }
        return len;
    }
}