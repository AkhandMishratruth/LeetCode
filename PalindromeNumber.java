class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        ArrayList<Integer> ar=  new ArrayList<Integer>();
        while(x!=0){
            ar.add(x%10);
            x = x / 10;
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<ar.size()/2; i++)
            st.push(ar.get(i));
        int s = (ar.size()%2==0? ar.size()/2: ar.size()/2+1);
        for(int i=s;i<ar.size();i++){
            if(st.pop()!=ar.get(i))
                return false;
        }
        return true;
    }
}
