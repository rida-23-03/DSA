class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
           String curr=tokens[i];
           if(curr.equals("+")){
            int a=st.pop();
            int b=st.pop();
            st.push(a+b);
           }
            else if(curr.equals("-")){
            int a=st.pop();
            int b=st.pop();
            st.push(b-a);
           }
           else if(curr.equals("*")){
            int a=st.pop();
            int b=st.pop();
            st.push(b*a);
           }
           else if(curr.equals("/")){
            int a=st.pop();
            int b=st.pop();
            st.push(b/a);
           }
           else{
            st.push(Integer.parseInt(curr));//forr "20"->20 string to int
           }
           
        }
        return st.pop();
    }
}