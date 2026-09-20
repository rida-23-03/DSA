class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;
        Stack<Integer> st=new Stack<>();
        Stack<Integer> st1=new Stack<>();
        int[] pse=new int[n];
        int[] nse=new int[n];
        Arrays.fill(pse,0);
        Arrays.fill(nse,n);
        for(int i=0;i<n;i++){
            int curr=i;
            while(!st.isEmpty() && h[st.peek()]>=h[curr]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek()+1;
            }
            st.push(curr);
        }
        for(int i=n-1;i>=0;i--){
            int curr=i;
            while(!st1.isEmpty() && h[st1.peek()]>=h[curr]){
                st1.pop();
            }
            if(!st1.isEmpty()){
                nse[i]=st1.peek();
            }
            st1.push(curr);
        }
        int max=0;
        int area=0;
        for(int i=0;i<n;i++){
            area=h[i]*(nse[i]-pse[i]);
            if(area>max){
                max=area;
            }
        }
        return max;
        
    }
}