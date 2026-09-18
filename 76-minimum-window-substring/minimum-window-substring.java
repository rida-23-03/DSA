class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int l=0;
        int have=0;
        int minlen=Integer.MAX_VALUE;
        int need=t.length();
        int start=0;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
                if(mp.get(c)>=0){
                    have++;
                }
            }
            while(have==need){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    start=l;
                }
                char cu=s.charAt(l);
                if(mp.containsKey(cu)){
                    mp.put(cu,mp.get(cu)+1);

                    if(mp.get(cu)>0){
                        have--;
                    }
                }
                l++;
            }
        }
        if(minlen==Integer.MAX_VALUE) return "";
        return s.substring(start,minlen+start);
    }
}