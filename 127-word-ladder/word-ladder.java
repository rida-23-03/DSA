class Solution {
    public int ladderLength(String bw, String ew, List<String> wl) {
        HashSet<String> set=new HashSet<>();
        int f=0;
        for(String x:wl){
            if(x.equals(ew)){
                f=1;
            }
            set.add(x);
        }
        if(f==0) return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(bw);
        int l=0;
        while(!q.isEmpty()){
            l++;
            int s=q.size();
            while(s-- >0){
                String curr=q.poll();
                for(int i=0;i<curr.length();i++){
                    StringBuilder t=new StringBuilder(curr);
                    for(char c='a';c<='z';c++){
                        t.setCharAt(i,c);
                        String t1=t.toString();
                        if(t1.equals(ew)) return l+1;
                        if(set.contains(t1)){
                            q.add(t1);
                            set.remove(t1);
                        }
                    }

                }
            }
        }
        return 0;
    }
}