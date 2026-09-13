class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char curr=t.charAt(i);
            if(!mp.containsKey(curr)) return false;
            if(mp.containsKey(curr)){
                mp.put(curr,mp.get(curr)-1);
                if(mp.get(curr)==0){
                    mp.remove(curr);
                }
            }
        }
        if(mp.isEmpty()) return true;
        else return false;
    }
}