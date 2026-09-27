class Solution {
    public boolean wordPattern(String p, String s) {
        HashMap<Character,String> m1=new HashMap<>();
        HashMap<String,Character> m2=new HashMap<>();
        String[] t=s.split("\\s+");
        if(p.length()!=t.length) return false;
        for(int i=0;i<p.length();i++){
            char x=p.charAt(i);
            String y=t[i];
            if(m1.containsKey(x) && !m1.get(x).equals(y)){
                return false;
            }
            if(m2.containsKey(y) && m2.get(y)!=x){
                return false;
            }
            m1.put(x,y);
            m2.put(y,x);
        }
        return true;
    }
}