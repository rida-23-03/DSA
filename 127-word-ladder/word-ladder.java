class Solution {
    public int ladderLength(String bw, String ew, List<String> wl) {
        HashSet<String> set=new HashSet<>(wl);
        if(!set.contains(ew)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.add(bw);
        int l=0;
        while(!q.isEmpty()){
            l++;
            int size=q.size();
            for(int k=0;k<size;k++){
                String curr=q.poll();
                for(int i=0;i<curr.length();i++){
                    StringBuilder sb=new StringBuilder(curr);
                    for(char c='a';c<='z';c++){
                        sb.setCharAt(i,c);
                        String t=sb.toString();
                        if(t.equals(ew)) return l+1;
                        if(set.contains(t)){
                            q.add(t);
                            set.remove(t);
                        }

                    }
                }
            }
        }
        return 0;
        
    }
}