class Solution {
    public boolean canConstruct(String r, String m) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<m.length();i++){
            char c=m.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        for(int i=0;i<r.length();i++){
            char c=r.charAt(i);
            if(!mp.containsKey(c)) return false;
            else{
                mp.put(c,mp.getOrDefault(c,0)-1);
                if(mp.get(c)==0){
                    mp.remove(c);
                }
            }
        }
        return true;
    }
}