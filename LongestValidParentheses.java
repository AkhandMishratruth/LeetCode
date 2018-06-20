class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        //System.out.println(l);
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(')', -1));
        for(int i = 0;i<l;i++){
            if(!st.isEmpty() && s.charAt(i)==')' && st.peek().key=='(')
                st.pop();
            else
                st.push(new Pair(s.charAt(i), i));
        }
        int max = 0, right = l;
        while(!st.isEmpty()){
            Pair ent = st.pop();
            max = Math.max(right - ent.getValue() - 1, max);
            right = ent.getValue();
        }
        return max;
    }
}
class Pair{
    char key;
    int value;
    Pair(char c, int v){
        key = c;
        value = v;
    }
    public int getValue(){
        return value;
    }
}
