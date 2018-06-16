class Solution {
    public String fractionToDecimal(int n1, int d1) {
        long n = n1, d = d1;
        Double dou = n*1.0/d;
        System.out.println(dou);
        if(n%d==0)
            return Long.toString(n/d);
        boolean neg = false;
        if( (n < 0 && d > 0) || (d < 0 && n > 0)){
            neg = true;
            if(n<0)
                n = -n;
            if(d<0)
                d = -d;
        }
        long bd = n/d;
        StringBuilder st = new StringBuilder("");
        long r = n%d;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int ind=-1, i=0;
        while(r!=0){
            if(map.containsKey(r)){
                //System.out.println((r*10)%d);
                ind = map.get(r);
                break;
            }
            st.append(Long.toString((r*10)/d));
            map.put(r, i++);
            System.out.println(r*10/d);
            System.out.println((r*10)%d);
            r = (r*10)%d;
        }
        if(ind!=-1)
            return (neg? "-" : "") + Long.toString(bd) + "." + st.insert(ind, "(").append(")").toString();
        return (neg? "-" : "") + Long.toString(bd) + "." + st.toString();
    }
}
